import pandas as pd
import requests

df = pd.read_csv("data/training.csv")
df_test = pd.read_csv("data/testing.csv")

requests.post("http://127.0.0.1:5000/train", json=df.to_json(orient="records"))
r = requests.post("http://127.0.0.1:5000/predict", json=df_test.to_json(orient="records"))

print(r.status_code, r.text)
