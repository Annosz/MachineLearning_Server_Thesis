import adviewcount
import pandas as pd


df = pd.read_csv("data/training.csv")

print(df.head())
adviewcount.clear_dataframe(df)

#rmse = adviewcount.train_ml(df, 0.8, 500, 0.05, 7)

#print(rmse)

