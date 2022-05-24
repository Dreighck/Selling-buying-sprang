### List of Microservices Identified 
- MicroService - login/register/account
- MicroService - product/inventory
- MicroService - website/userprofile/comments
- RgistrationService
- GatewayService
********************************* 
### Microservice - 1
#### Models 
- Model - login/register
    
    - Attribute - 1: type (Primary key) User that is registering
    - Attribute - 2: type      register form for user details           
    - Attribute - 3: type       login form for server/storing user to database
    - Attribute - n: type          logoff redirecting back to home view


- Model - Register Form user fills out/login for for login credintials/User account of individual user and their details that they can update/edit/see their products the posted
    
    - Attribute - 1: type (Primary key)  user id
    - Attribute - 2: type     list all products from user(getProducts)
    - Attribute - 3: type       add product/edit userDetails
    - Attribute - n: type         delete user from database
#### Endpoints 
- /api/v1/register - GET/POST/DELETE/PUT –- <description of the resource operation exposed by this api>  
- /api/v1/login - GET/POST/DELETE/PUT –- <description of the resource operation exposed by this api>
- /api/v1/userPage - GET/POST/DELETE/PUT –- <description of the resource operation exposed by this api>   
********************************** 
### Microservice - product/inventory/tags-posts (product form for user to fill out)
#### Models 
- Model - Product 
    
    - Attribute - 1: type (Primary key) user id its made by
    - Attribute - 2: type    product description
    - Attribute - 3: type         product price
    - Attribute - n: type      product tag(houseware, lawn&garden, electronic, automobile)
- Model - n 
    
    - Attribute - 1: type (Primary key)    get all products associated with specific tag
    - Attribute - 2: type               edit/update product lists as users edit/update them
    - Attribute - 3: type            delete product from site/database/inventory once its marked as purchased from user
    - Attribute - n: type                    
#### Endpoints 
- /api/v1/ListofAllProductPosts(general) - GET/POST/DELETE/PUT –- <description of the resource operation exposed by this api> 
- /api/v1/ListofAllProductPosts(associated w/tag from description) - GET/POST/DELETE/PUT –- <description of the resource operation exposed by this api>
- /api/v1/ListofAllProductPosts(associated w/user that posted the product) - GET/POST/DELETE/PUT –- <description of the resource operation exposed by this api>
- /api/v1/ - GET/POST/DELETE/PUT –- <description of the resource operation exposed by this api>  
********************************** 
## EXAMPLE:
## ===========  
### EquipmentService 
#### Models 
- Equipment 
   - equipment_id: int (auto-generated) Primary Key 
   - name: String (text, max_50, required) 
   - location: String (google map link, GPS coordinate, required) 
   - aging: int (range of 1 to 100, required) 
   - comment: String (text, max_1000, optional/nullable) 
 
#### Endpoints (APIs) 
- /api/v1/robospector/equipment - GET - Get all the resources 
- /api/v1/robospector/equipment- POST- Create equipment 
- /api/v1/robospector/equipment- PUT- Update an existing equipment 
- /api/v1/robospector/equipment- DELETE- Delete resource with equipment in requestbody 
************************************ 

