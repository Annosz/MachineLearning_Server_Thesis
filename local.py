import adviewcount
import pandas as pd
import time


df = pd.read_csv("data/training.csv")

start = time.time()
rmse = adviewcount.train_ml(df, True, 0.8, 20, 0.1, 4)
end = time.time()

print("Time of training: " + str(end - start))
print("RMSE: " + str(rmse))
