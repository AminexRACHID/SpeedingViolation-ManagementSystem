# SpeedingViolationManagementSystem

The Speeding Violation Management System is a distributed application based on microservices architecture. It is designed to efficiently manage and automate the process of handling speeding violations detected by automatic radar systems.

The system consists of three microservices:

Radar Management Microservice: This microservice handles the management of radar devices. Each radar is defined by its unique identifier, maximum speed, and geographical coordinates (longitude and latitude). It allows operations such as creating, reading, updating, and deleting radar information, as well as retrieving specific details about individual radars.

Vehicle Registration Microservice: This microservice manages vehicle registration information and ownership. Each vehicle is associated with a single owner. Owners are defined by their unique identifier, name, date of birth, email, etc. Vehicle details include its unique identifier, license plate number, make, fiscal power, and model. The microservice enables operations such as creating, reading, updating, and deleting owner and vehicle records, as well as retrieving specific information about owners or vehicles.

Violation Management Microservice: This microservice handles the management of speeding violations. Each violation is defined by its unique identifier, date, radar number that detected the violation, vehicle license plate number, vehicle speed, radar maximum speed, and fine amount. It facilitates operations such as creating violations when a speeding incident occurs, reading specific violation details, and allowing owners to view their own violations.

The system not only supports the standard data consultation and modification operations but also allows users to report speeding incidents, which trigger the creation of corresponding violations. Additionally, it provides a feature for owners to conveniently access and review their own violation records.

The microservices within this distributed system communicate with each other to share and synchronize data, utilizing separate databases for their specific entities. Communication can be achieved through protocols like HTTP or message queues, ensuring seamless interaction between the microservices.

By leveraging the "Speeding Violation Management System," authorities can streamline the process of managing radar devices, vehicle registrations, and speeding violations, leading to enhanced automation, efficiency, and accuracy in handling these infractions.

## architectural technique

<div>
<img src="https://github.com/AmineRACHID/TP5_architecture_micro-service/assets/127174852/fee00a06-5ae4-42fa-83a5-29d401cd0be1">
</div>

## Class Diagram

<div>
<img src="https://github.com/AmineRACHID/TP5_architecture_micro-service/assets/127174852/8332c7b6-5cdd-4b56-b8ed-74a9455af0d6">
</div>

## Backend Services

### Immatriculation-service

#### REST :

getAllProprietaires
<div>
<img src="https://github.com/AmineRACHID/TP5_architecture_micro-service/assets/127174852/c7c5f353-e25d-4dd6-8fc1-526fe3d8a7a7">
</div>

getProprietaireByNom
<div>
<img src="https://github.com/AmineRACHID/TP5_architecture_micro-service/assets/127174852/294b2ad5-25d6-4eca-a176-5bc777072b99">
</div>

getProprietairesById
<div>
<img src="https://github.com/AmineRACHID/TP5_architecture_micro-service/assets/127174852/9a4d95da-9a51-42b5-bed3-b87035c5619f">
</div>

AddProprietaire
<div>
<img src="https://github.com/AmineRACHID/TP5_architecture_micro-service/assets/127174852/78190588-60f3-4214-bbbf-1036470a7837">
</div>

updateProprietaire
<div>
<img src=https://github.com/AmineRACHID/TP5_architecture_micro-service/assets/127174852/9ca0949e-fb73-4dbb-9782-7990aad64f5b">
</div>

getVehicules
<div>
<img src="https://github.com/AmineRACHID/TP5_architecture_micro-service/assets/127174852/311a7525-2902-4bc4-8c71-b203a5fc5cd3">
</div>

getvehiculesByID
<div>
<img src="https://github.com/AmineRACHID/TP5_architecture_micro-service/assets/127174852/19d5d030-1f64-4c96-8bc4-ed03f8866881">
</div>

#### GRPC :

getProprietaireById
<div>
<img src="https://github.com/AmineRACHID/TP5_architecture_micro-service/assets/127174852/8cc6e9ec-c412-4434-b56b-6966c910a35a">
</div>

getProprietaires
<div>
<img src="https://github.com/AmineRACHID/TP5_architecture_micro-service/assets/127174852/7cee18b5-3f2b-4e7f-bdd2-267cacf44dae">
</div>

AddProprietaire
<div>
<img src="https://github.com/AmineRACHID/TP5_architecture_micro-service/assets/127174852/e7f54c77-7a09-4f33-9817-b17ee7396fa6">
</div>

#### GraphQL :

getProprietaires
<div>
<img src="https://github.com/AmineRACHID/TP5_architecture_micro-service/assets/127174852/0f247ce9-f0af-460f-9234-6fb0aa34014e">
</div>

addProprietaire
<div>
<img src="https://github.com/AmineRACHID/TP5_architecture_micro-service/assets/127174852/d9aaee4b-dce0-4129-ade7-bda0f439b268">
</div>

deleteProprietaire
<div>
<img src="https://github.com/AmineRACHID/TP5_architecture_micro-service/assets/127174852/7329b185-ea9c-45f9-9f93-32d5604af0b4">
</div>

getVehicules
<div>
<img src="https://github.com/AmineRACHID/TP5_architecture_micro-service/assets/127174852/0b7dd4b7-ca30-4850-9312-a92516511a50">
</div>

getvehiculeById
<div>
<img src="https://github.com/AmineRACHID/TP5_architecture_micro-service/assets/127174852/70c05842-96ec-45d0-b957-b52d605c1f32">
</div>

#### Soap :

getProprietaireById
<div>
<img src="https://github.com/AmineRACHID/SpeedingViolationManagementSystem/assets/127174852/4d6d6fec-44a2-4eda-b149-d37da04f0660">
</div>

addProprietaire
<div>
<img src="https://github.com/AmineRACHID/SpeedingViolationManagementSystem/assets/127174852/9a06da06-115d-448d-b4d8-8d55b30339ef">
</div>

UpdateProprietaire
<div>
<img src="https://github.com/AmineRACHID/SpeedingViolationManagementSystem/assets/127174852/1d30b507-db4b-4f5c-87b2-d8eb2e32f9cf">
</div>


### Infraction-service

getAllinfraction
<div>
<img src="https://github.com/AmineRACHID/TP5_architecture_micro-service/assets/127174852/df3667a1-4d40-4bf6-b3a1-a7227eb72796">
</div>

addInfraction
<div>
<img src="https://github.com/AmineRACHID/TP5_architecture_micro-service/assets/127174852/7dcb6af7-17f2-4690-8941-d7f1bf07e919">
</div>

saveInfraction
<div>
<img src="https://github.com/AmineRACHID/TP5_architecture_micro-service/assets/127174852/9de8302e-1fb7-478f-a453-c7d4ec4287b4">
</div>

### Radar-service

getAllRadars
<div>
<img src="https://github.com/AmineRACHID/TP5_architecture_micro-service/assets/127174852/696bd8ce-435f-488b-9d14-86c449ef7753">
</div>

getRadarById
<div>
<img src="https://github.com/AmineRACHID/TP5_architecture_micro-service/assets/127174852/d530fe49-6a7a-4780-849f-c47453c11952">
</div>

saveRadar
<div>
<img src="https://github.com/AmineRACHID/TP5_architecture_micro-service/assets/127174852/7af37c08-3e81-453a-9c4b-944788f08c91">
</div>

updateRadar
<div>
<img src="https://github.com/AmineRACHID/TP5_architecture_micro-service/assets/127174852/22ed85bc-4b88-4ff5-b1be-77b5d2436e2e">
</div>


## Frontend with Angular

authentification Page with Keycloak
<div>
<img src="https://github.com/AmineRACHID/SpeedingViolation-ManagementSystem/assets/127174852/ae3678ae-b1e5-4d54-a386-430e8aca6c5c)">
</div>

vehicules Page
<div>
<img src="https://github.com/AmineRACHID/SpeedingViolation-ManagementSystem/assets/127174852/53800370-7cf1-4f6f-9977-4aa9a853fa6c">
</div>

AddVehicule Page
<div>
<img src="https://github.com/AmineRACHID/SpeedingViolation-ManagementSystem/assets/127174852/7d132783-d31c-43d4-91a9-9555a3cbab5f">
</div>

UpdateVehicules Page
<div>
<img src="https://github.com/AmineRACHID/SpeedingViolation-ManagementSystem/assets/127174852/f5defcd9-f0a7-49dc-a7a4-f0cef7e9dbdf">
</div>

Proprietaires Page
<div>
<img src="https://github.com/AmineRACHID/SpeedingViolation-ManagementSystem/assets/127174852/6b130684-3f76-4241-be20-4375282d9661">
</div>

AddProprietaire Page
<div>
<img src="https://github.com/AmineRACHID/SpeedingViolation-ManagementSystem/assets/127174852/17176641-394a-49bb-81b5-09f90c88bf89">
</div>

UpdateProprietaire Page
<div>
<img src="https://github.com/AmineRACHID/SpeedingViolation-ManagementSystem/assets/127174852/bff93b4f-5e14-42fd-ab01-ac655270f7d6">
</div>


infractions Page
<div>
<img src="https://github.com/AmineRACHID/SpeedingViolation-ManagementSystem/assets/127174852/048a5c59-e3a6-445d-a58e-9d471629e0c9">
</div>

radar Page
<div>
<img src="https://github.com/AmineRACHID/SpeedingViolation-ManagementSystem/assets/127174852/a39a0fca-6853-4d2b-9ca3-1f86c72da34c">
</div>

AddRadar Page
<div>
<img src="https://github.com/AmineRACHID/SpeedingViolation-ManagementSystem/assets/127174852/91aff92a-36cd-4d48-a620-f8ee9dbf59b0">
</div>

UpdateRadar Page
<div>
<img src="https://github.com/AmineRACHID/SpeedingViolation-ManagementSystem/assets/127174852/2cda9c98-babc-4291-9053-62c847781c2d">
</div>
