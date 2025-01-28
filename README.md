# CLIENT_INTERVIEW_ENABLEMENT


# InfyDASystem -first_EXERCISE

InfyDASystem is an application designed for allocating desktops to trainees. The application includes the following functionalities:

1. Add new trainee.
2. Get desktop allocation details of each trainee.

This document provides an overview of the code structure and implementation details.

---

## **Project Structure**

### **1. Model Classes (Already Implemented)**

#### **TraineeDTO**
This class represents the trainee details.
- Attributes:
  - `id` (Integer): Trainee ID
  - `name` (String): Trainee Name
  - `phoneNo` (String): Trainee Phone Number
  - `desktop` (DesktopDTO): Desktop details
- Methods:
  - Getters and setters for all attributes.
  - `toString()` method.

#### **DesktopDTO**
This class represents the desktop details.
- Attributes:
  - `machineName` (String): Machine name
  - `make` (String): Make of the desktop
- Methods:
  - Getters and setters for all attributes.
  - `toString()` method.

### **2. SpringConfig Class**
The configuration class for the application.

```java
package com.infy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.infy.service", "com.infy.repository"})
public class SpringConfig {
    // This class is used for Spring configuration and component scanning
}
```

### **3. Validator Class**
This class validates the input values.

```java
package com.infy.validator;

import com.infy.dto.TraineeDTO;
import com.infy.exception.InfyDASystemException;

public class Validator {

    // Validate the trainee details
    public static void validate(TraineeDTO trainee) throws InfyDASystemException {
        if (trainee == null || trainee.getId() == null || trainee.getName() == null ||
            trainee.getPhoneNo() == null || !validateTraineePhoneNo(trainee.getPhoneNo())) {
            throw new InfyDASystemException("Validator.INVALID_DETAILS");
        }
    }

    // Validate the trainee phone number
    public static Boolean validateTraineePhoneNo(String phoneNo) {
        if (phoneNo.length() != 10) {
            return false;
        }
        char firstDigit = phoneNo.charAt(0);
        return firstDigit == '7' || firstDigit == '8' || firstDigit == '9';
    }
}
```

### **4. InfyDASystemServiceImpl Class**
This is the service class of the application.

```java
package com.infy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.TraineeDTO;
import com.infy.exception.InfyDASystemException;
import com.infy.repository.InfyDASystemRepository;
import com.infy.validator.Validator;

@Service("infyDASystemService")
public class InfyDASystemServiceImpl implements InfyDASystemService {

    @Autowired
    private InfyDASystemRepository infyDASystemRepository;

    // Add a new trainee
    @Override
    public Integer addNewTrainee(TraineeDTO trainee) throws InfyDASystemException {
        try {
            // Validate trainee details
            Validator.validate(trainee);
            // Add trainee details to the repository
            return infyDASystemRepository.addNewTrainee(trainee);
        } catch (InfyDASystemException e) {
            System.err.println("Exception: " + e.getMessage());
            throw e;
        }
    }

    // Get desktop allocation details
    @Override
    public TraineeDTO getAllocationDetails(Integer traineeId) throws InfyDASystemException {
        try {
            TraineeDTO trainee = infyDASystemRepository.getAllocationDetails(traineeId);
            if (trainee == null) {
                throw new InfyDASystemException("Service.NO_DETAILS_FOUND");
            }
            return trainee;
        } catch (InfyDASystemException e) {
            System.err.println("Exception: " + e.getMessage());
            throw e;
        }
    }
}
```

### **5. InfyDASystemRepositoryImpl Class**
This is the repository class of the application.

Add the following annotation to mark it as a repository:

```java
@Repository("infyDASystemRepository")
public class InfyDASystemRepositoryImpl implements InfyDASystemRepository {
    // Already implemented methods
}
```

### **6. UserInterface Class**
This class is used as an interface between the application and the user. The methods of this class are already implemented.

---

## **How to Run the Application**

1. Import the downloaded project into your IDE (e.g., Eclipse).
2. Ensure that all dependencies (e.g., Spring Framework) are configured properly.
3. Run the application and test the following scenarios:

   ### **Test Cases**

   #### **addNewTrainee()**
   - **Valid Input:**
     ```java
     TraineeDTO trainee = new TraineeDTO();
     trainee.setId(1008);
     trainee.setName("Robin");
     trainee.setPhoneNo("9040555861");
     ```
     **Expected Output:** `Trainee added successfully with id: 1008`

   - **Invalid Input:**
     ```java
     TraineeDTO trainee = new TraineeDTO();
     trainee.setId(1008);
     trainee.setName("Robin");
     trainee.setPhoneNo("555861");
     ```
     **Expected Output:** `Invalid trainee details`

   #### **getAllocationDetails()**
   - **Valid Input:**
     ```java
     Integer traineeId = 1001;
     ```
     **Expected Output:**
     ```
     TraineeDTO [id=1001, name=Adam, phoneNo=9658014355, desktop=DesktopDTO [machineName=MYSGEC111111D, make=Acer]]
     ```

   - **Invalid Input:**
     ```java
     Integer traineeId = 1002;
     ```
     **Expected Output:** `No trainee exists for the specified id.`

---

## **Error Handling**

1. **Validator.INVALID_DETAILS:** Thrown when trainee details are invalid.
2. **Service.NO_DETAILS_FOUND:** Thrown when no trainee is found for the given ID.

---

## **Dependencies**

- Java 8+
- Spring Framework
- Any database for storing trainee details (as per repository implementation).

---

## **Contact**
For any queries, please reach out to the development team.

