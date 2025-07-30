from fastapi import FastAPI
from pydantic import BaseModel
import joblib
import numpy as np
import os


app = FastAPI()

# Load model relative to this file location
BASE_DIR = os.path.dirname(os.path.abspath(__file__))
model_path = os.path.join(BASE_DIR, "fare_rf_model.joblib")
model = joblib.load(model_path)

class Features(BaseModel):
    distance: float
    fuel_price: float
    car_mileage: float
    riders: int
    fuel_type_petrol: int   # 1 if petrol, else 0
    fuel_type_diesel: int   # 1 if diesel, else 0
    fuel_type_cng: int      # 1 if CNG, else 0
    fuel_type_lpg: int      # 1 if LPG, else 0

@app.post("/predict")
def predict(features: Features):
    # Build feature array in the exact order your model expects
    X = np.array([[
        features.distance,
        features.fuel_price,
        features.car_mileage,
        features.riders,
        features.fuel_type_petrol,
        features.fuel_type_diesel,
        features.fuel_type_cng,
        features.fuel_type_lpg
    ]])
    pred = model.predict(X)[0]
    return {"predicted_fare": round(float(pred), 2)}
