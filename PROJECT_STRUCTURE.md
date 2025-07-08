# Project Structure

This document provides a detailed overview of the Coffee Management Store project structure.

## 📁 Root Directory

```
coffee-management-store/
├── 📄 README.md                    # Main project documentation
├── 📄 LICENSE                      # MIT License
├── 📄 CONTRIBUTING.md              # Contribution guidelines
├── 📄 CHANGELOG.md                 # Version history and changes
├── 📄 PROJECT_STRUCTURE.md         # This file
├── 📄 .gitignore                   # Git ignore rules
├── 📄 pom.xml                      # Maven configuration
├── 📄 run.sh                       # Executable run script
└── 📄 database_setup.sql           # Database schema (legacy)
```

## 📁 Source Code Structure

```
src/
└── main/
    ├── java/
    │   └── com/
    │       └── example/
    │           └── groupproject/
    │               ├── 📄 Main.java                    # Application entry point
    │               ├── 📄 LoginController.java          # Login and navigation logic
    │               ├── 📄 FXMLDocumentController.java   # Inventory management
    │               ├── 📄 H2DbConnection.java           # H2 database connection
    │               ├── 📄 DbConnection.java             # Legacy MySQL connection
    │               ├── 📄 AlertDialog.java              # Custom alert dialogs
    │               └── 📄 NameList.java                 # Data model for products
    └── resources/
        ├── 📄 login.fxml                              # Login screen UI
        ├── 📄 overview.fxml                           # Dashboard UI
        ├── 📄 FXMLDocument.fxml                       # Inventory management UI
        ├── 📄 invoice.fxml                            # Invoice creation UI
        ├── 📄 restock.fxml                            # Restock management UI
        └── 📄 design.css                              # Application styling
```

## 📋 File Descriptions

### Core Application Files

#### Main.java
- **Purpose**: Application entry point
- **Key Features**: 
  - JavaFX application initialization
  - Window size configuration (500x380px)
  - Scene setup and display

#### LoginController.java
- **Purpose**: Handles login authentication and navigation
- **Key Features**:
  - User authentication logic
  - Window size management for different screens
  - Navigation between different FXML scenes
  - Logout functionality

#### FXMLDocumentController.java
- **Purpose**: Inventory management functionality
- **Key Features**:
  - CRUD operations for products
  - Database integration
  - Search functionality
  - Table data management
  - Navigation back to dashboard

#### H2DbConnection.java
- **Purpose**: H2 database connection management
- **Key Features**:
  - In-memory database setup
  - Automatic table creation
  - Connection pooling
  - SQL query execution

### UI Files (FXML)

#### login.fxml
- **Window Size**: 500x380px
- **Features**: 
  - Username/password fields
  - Login button
  - Coffee-themed styling
  - Error message display

#### overview.fxml
- **Window Size**: 800x600px
- **Features**:
  - Dashboard navigation buttons
  - Inventory management access
  - Invoice creation access
  - Restock management access
  - Logout functionality

#### FXMLDocument.fxml
- **Window Size**: 1400x800px
- **Features**:
  - Product form (ID, name, price, quantity)
  - Add/Update buttons
  - Product table display
  - Search functionality
  - Back to dashboard button

### Styling

#### design.css
- **Purpose**: Application-wide styling
- **Features**:
  - Coffee-themed color scheme
  - Modern button styling
  - Form field styling
  - Table styling
  - Responsive design elements

## 🔧 Configuration Files

### pom.xml
- **Purpose**: Maven project configuration
- **Key Dependencies**:
  - JavaFX Maven plugin
  - H2 database
  - Java 8+ compatibility
  - Build and run configurations

### run.sh
- **Purpose**: Executable run script
- **Features**:
  - Environment validation
  - Build process automation
  - Error handling
  - User-friendly output

## 📊 Database Schema

### Legacy (database_setup.sql)
- MySQL schema for reference
- Product table structure
- User authentication table

### Current (H2DbConnection.java)
- In-memory H2 database
- Automatic table creation
- Product inventory management
- User authentication system

## 🎨 UI/UX Design

### Color Scheme
- **Primary**: Coffee browns (#a67c52, #8d6748)
- **Secondary**: Beige tones (#e6d3b3, #fffaf3)
- **Accent**: Red for logout (#e74c3c)

### Window Sizes
- **Login**: 500x380px (compact)
- **Dashboard**: 800x600px (spacious)
- **Inventory**: 1400x800px (large for data entry)
- **Other screens**: 500x350px (medium)

### Design Principles
- Coffee shop branding
- Professional appearance
- User-friendly interface
- Responsive layouts
- Consistent styling

## 🚀 Build and Deployment

### Development
```bash
mvn clean compile
mvn javafx:run
```

### Production
```bash
mvn clean package
java -jar target/coffee-management-store-1.0-SNAPSHOT.jar
```

### Quick Start
```bash
./run.sh
```

## 📝 Documentation

### README.md
- Project overview
- Setup instructions
- Feature descriptions
- Troubleshooting guide

### CONTRIBUTING.md
- Contribution guidelines
- Coding standards
- Development setup
- Pull request process

### CHANGELOG.md
- Version history
- Feature additions
- Bug fixes
- Technical improvements

## 🔒 Security

### Authentication
- Multiple user roles
- Secure password handling
- Session management
- Role-based access control

### Database
- In-memory H2 database
- No external dependencies
- Automatic setup
- Data persistence

## 🧪 Testing

### Manual Testing
- Login functionality
- Navigation between screens
- CRUD operations
- Search functionality
- Window sizing

### Future Testing
- Unit tests for controllers
- Integration tests for database
- UI automation tests
- Performance testing

## 📈 Future Enhancements

### Planned Features
- Invoice generation
- Sales reporting
- Advanced search
- Data export
- User management

### Technical Improvements
- Unit test coverage
- Performance optimization
- Additional UI themes
- Mobile responsiveness
- Multi-language support

---

This structure provides a clean, organized, and professional foundation for the Coffee Management Store project, ready for GitHub deployment and open source collaboration. 