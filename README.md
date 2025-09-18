🏥 Medical Appointment System

A RESTful API for managing medical appointments built with Spring Boot.

📊 Class Diagram

User (Abstract)
├── Patient
└── Doctor
└── Appointment (links both)

🚀 Quick Start

# 1. Clone & setup
git clone https://github.com/your-username/medapp.git
cd medapp

# 2. Configure database in application.properties

# 3. Run
./mvnw spring-boot:run
🛠️ Tech Stack
Java 17 + Spring Boot 2.7.0

MySQL + JPA/Hibernate

Maven + JUnit 5

📍 API Endpoints
Resource          	GET  POST	 PUT	DELETE
/api/patients     	✅  	✅   ✅	 ✅
/api/doctors	      ✅	  ✅   ✅   ✅
/api/appointments	  ✅	  ✅   ✅ 	 ✅


🎯 Next Features

🔐 Authentication with Spring Security
📧 Email notifications
📱 Mobile app
💳 Payment integration

#Presentation
https://gamma.app/docs/Sistema-de-Citas-Medicas-1iecl3uoukk2he0


👨‍💻 Developer
Rafaela Ridolphi
