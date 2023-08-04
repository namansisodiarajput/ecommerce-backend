# ecommerce-backend
e-commmerce backend using spring boot, mysql, influx db & grafana setup

## List of api 
#### Customer:
 - Get Api (email))
 - Delete Api 
 - Update Api(email))
 - Post Api 

#### Product:
- List all product,  
- Delete Api 
- Update Api
- Post Api

#### Order:
- Post Api (CustomerId, ProductId)
- Get Product by Customer

## Swagger - all apis are unauthenticated. directly can be tested from swagger.
Swagger Link - http://localhost:8080/swagger-ui/index.html
<img width="1581" alt="image" src="https://github.com/namansisodiarajput/ecommerce-backend/assets/19189211/46808c92-d6cb-4d29-a3c2-3bed02c7a1fa">

## Mysql tables

### Change database crediential according to own preference
<img width="1005" alt="image" src="https://github.com/namansisodiarajput/ecommerce-backend/assets/19189211/313b66f2-db91-4aee-b450-b769180e726b">

### Product
<img width="1280" alt="image" src="https://github.com/namansisodiarajput/ecommerce-backend/assets/19189211/cbc8fbfc-49cf-4c25-b5e9-b01587b92c85">

### Customer
<img width="1318" alt="image" src="https://github.com/namansisodiarajput/ecommerce-backend/assets/19189211/4b869bcd-0268-45d1-9fe3-f48a9b47e085">

### Customer Order
<img width="1344" alt="image" src="https://github.com/namansisodiarajput/ecommerce-backend/assets/19189211/a443f282-8e04-48e3-a9dd-b8b6978af88b">


## InfluxDB Matrices Setup Steps 

1. #### Login Grafana Cloud or Setup Locally (i have setup cloud) -  https://www.influxdata.com/products/influxdb-cloud/
2. #### Create Bucket name of your choice (i am using name ecommerce_matrices) - <img width="1777" alt="image" src="https://github.com/namansisodiarajput/ecommerce-backend/assets/19189211/5b9af47a-8f31-45da-a265-b5897c3f4472">
3. #### Generate token for application access - <img width="1786" alt="image" src="https://github.com/namansisodiarajput/ecommerce-backend/assets/19189211/35e5d856-357e-41ad-b527-46476dbfc800">
4. #### add host url & token in ssm parameter - <img width="1006" alt="image" src="https://github.com/namansisodiarajput/ecommerce-backend/assets/19189211/3b4edc1a-2ae6-4b0c-98ae-69efcf4435bd">
5. #### update bucket name also in MatricesPublishesServiceImpl.class line 61 - <img width="1019" alt="image" src="https://github.com/namansisodiarajput/ecommerce-backend/assets/19189211/66938af9-f1cc-4608-b93c-1d1c3b83a7fc">
6. #### Hit create customer or create product api metrics will start getting published
7. #### Check data explored in influx db cloud you will see published metrices <img width="1594" alt="image" src="https://github.com/namansisodiarajput/ecommerce-backend/assets/19189211/a9752de6-050c-408e-a88b-ddd3b7cc8ded">

## Connect Grafana with InfluxDB 
#### Follow this offical link to connect influx db with grafana - https://docs.influxdata.com/influxdb/cloud/tools/grafana/
#### now you will be able to sync influx db data into grafana dashboard

#### View board to show all email 
<img width="1789" alt="image" src="https://github.com/namansisodiarajput/ecommerce-backend/assets/19189211/9a7d785a-25f7-4113-9a33-4d3a80d9b9dc">

#### View board to show customer count
<img width="1791" alt="image" src="https://github.com/namansisodiarajput/ecommerce-backend/assets/19189211/80ddeaf0-3512-48d8-977d-a8adc4b72666">

#### Createdat view board
<img width="1411" alt="image" src="https://github.com/namansisodiarajput/ecommerce-backend/assets/19189211/04e17c51-001b-4825-af35-09de550c4e33">


   








