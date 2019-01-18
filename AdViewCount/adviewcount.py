import pandas as pd
import numpy as np
from sklearn.model_selection import train_test_split
from sklearn.ensemble import GradientBoostingRegressor
from sklearn.metrics import mean_squared_error
from sklearn.preprocessing import StandardScaler
from sklearn.externals import joblib
from math import sqrt

# --------------------------------------------------------
# Data preparation steps.

def categorial_without_missing_handling(df, column):
    df = pd.get_dummies(df, columns=[column])
    return df

def categorial_with_missing_handling(df, column):
    df[column + '_missing'] = df[column].isnull()
    df[column] = df[column].fillna(df[column].mode()[0])
    df = pd.get_dummies(df, columns=[column])
    return df

def categorial_values(df):
    df = categorial_without_missing_handling(df, "city")
    df = categorial_with_missing_handling(df, "property_subtype")
    df = categorial_without_missing_handling(df, "view_type")
    df = categorial_with_missing_handling(df, "orientation")
    df = categorial_without_missing_handling(df, "garden_access")
    df = categorial_without_missing_handling(df, "heating_type")
    df = categorial_with_missing_handling(df, "elevator_type")

    df = categorial_without_missing_handling(df, "property_condition_type")

    return df

def clear_non_scalar_value(df, property, value, replace):
    df_clean = df.loc[df[property] == value, property] = replace
    return df

def fill_missing_numeric_values(df):
    df["small_room_cnt"] = df["small_room_cnt"].fillna(0)

    df["balcony_area"] = df["balcony_area"].fillna(0)

    df["building_floor_count"] = df["building_floor_count"].fillna(0)
    df = clear_non_scalar_value(df, "building_floor_count", 'more than 10', 11)

    df["property_floor"] = df["property_floor"].fillna(0)
    df = clear_non_scalar_value(df, 'property_floor', 'ground floor', 0)
    df = clear_non_scalar_value(df, 'property_floor', 'mezzanine floor', 0.5)
    df = clear_non_scalar_value(df, 'property_floor', 'basement', -1.0)
    df = clear_non_scalar_value(df, 'property_floor', '10 plus', 11)

    return df

def create_new_datas(df):
    df['sm_price'] = df['price_created_at'] / df['property_area']
    df = df.replace([np.inf, -np.inf], np.nan)
    df['sm_price'] = df['sm_price'].fillna(0)

    return df

def delete_unimportant_data(df):
    df = df.drop("county", axis=1)
    df = df.drop("property_type", axis=1)
    df = df.drop("postcode", axis=1)
    return df

def clear_dataframe(df):
    df = fill_missing_numeric_values(df)
    df = categorial_values(df)
    df = create_new_datas(df)
    df = delete_unimportant_data(df)

    return df




# --------------------------------------------------------
# Training.

def train_ml(df = None, train_test_ratio=1.0, n_estimators=500, learning_rate=0.01, max_depth=7, random_state=431):

    def evaluate_training(test, std_scale, gb):
        if test is not None:
            X_test = test[input_features]
            y_test = test[target]

            X_test = std_scale.transform(X_test)

            yhat_test = pd.Series(gb.predict(X_test), index=y_test.index)

            RMSE = sqrt(mean_squared_error(y_test, yhat_test))
            return RMSE
        return 0


    # Reading data
    if df is None:
        df = pd.read_csv("data/training.csv")
    df = clear_dataframe(df)

    # Choose features
    input_features = df.columns.tolist()
    input_features.remove('ad_view_cnt')
    input_features.remove('id')
    target = 'ad_view_cnt'

    # Regression
    ## Train-test split
    train = None
    test = None
    if train_test_ratio < 1.0:
        train, test = train_test_split(df, train_size=train_test_ratio, test_size=(1.0 - train_test_ratio), random_state=42)
    else:
        train = df

    X_train = train[input_features]
    y_train = train[target]

    ## Standardization
    std_scale = StandardScaler().fit(X_train)
    X_train = std_scale.transform(X_train)

    # Gradient Boosting
    gb = GradientBoostingRegressor(
        n_estimators=n_estimators,
        learning_rate=learning_rate,
        max_depth=max_depth,
        random_state=random_state)
    gb = gb.fit(X_train, y_train)

    joblib.dump(input_features, "models/input_features.pkl")
    joblib.dump(std_scale, "models/std_scale.pkl")
    joblib.dump(gb, "models/gradient_boosting_model.pkl")

    # Kiértékelés
    return evaluate_training(test, std_scale, gb)



# --------------------------------------------------------
# Predicting.

def predict_ml(df_test = None):
    input_features = joblib.load("./models/input_features.pkl")
    std_scale = joblib.load("./models/std_scale.pkl")
    gb = joblib.load("./models/gradient_boosting_model.pkl")

    # Reading data
    if df_test is None:
        df_test = pd.read_csv("data/testing.csv")
    df_test = clear_dataframe(df_test)

    # Choose features
    target = 'ad_view_cnt'

    # Features
    X_test = df_test[input_features]

    # Standardization
    X_test = std_scale.transform(X_test)

    final_result = pd.DataFrame(gb.predict(X_test), columns=['target'])
    final_result = np.clip(final_result,0,1000000)
    final_result.insert(0, 'id', df_test.id)

    # final_result.to_csv("data/prediction.csv", index=False)

    return final_result
