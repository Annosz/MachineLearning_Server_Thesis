import adviewcount
import pandas as pd
import time


for n_estimators in [200, 400, 600, 800, 1000]:
    for lr in [0.01, 0.05, 0.1]:
        for depth in [3, 5, 7]:
            df = pd.read_csv("data/training.csv")

            start = time.time()
            rmse = adviewcount.train_ml(df, False, 0.8, n_estimators, lr, depth)
            end = time.time()

            print("Number of estimators: " + str(n_estimators))
            print("Learning rate: " + str(lr))
            print("Depth of trees: " + str(depth))
            print("Time of training: " + str(end - start))
            print("RMSE: " + str(rmse))
            print()
            print()
