# ☕ Coffee Management Store

A modern JavaFX application for managing coffee shop inventory, sales, and restocking operations.

## 🚀 Features

- **User Authentication**: Secure login system with multiple user roles
- **Inventory Management**: Add, update, and track coffee products
- **Sales Tracking**: Generate invoices and track sales
- **Restock Management**: Monitor stock levels and manage restocking
- **Modern UI**: Beautiful, responsive interface with coffee-themed design
- **Database Integration**: H2 in-memory database for easy setup

## 🛠️ Technology Stack

- **Java**: Core application logic
- **JavaFX**: Modern UI framework
- **H2 Database**: In-memory database for data persistence
- **Maven**: Dependency management and build tool
- **CSS**: Custom styling for beautiful interface

## 📋 Prerequisites

- Java 8 or higher
- Maven 3.6 or higher
- Git (for cloning)

## 🚀 Quick Start

### 1. Clone the Repository
```bash
git clone https://github.com/yourusername/coffee-management-store.git
cd coffee-management-store
```

### 2. Build the Project
```bash
mvn clean compile
```

### 3. Run the Application
```bash
mvn javafx:run
```

Or use the provided script:
```bash
./run.sh
```

## 👤 Login Credentials

| Username | Password | Role |
|----------|----------|------|
| Admin    | Password | Administrator |
| Tonning  | Cheese51 | Manager |
| James    | JamesIsACat | Staff |
| Manager  | 123      | Manager |

## 🏗️ Project Structure

```
coffee-management-store/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── example/
│       │           └── groupproject/
│       │               ├── Main.java                 # Application entry point
│       │               ├── LoginController.java       # Login and navigation logic
│       │               ├── FXMLDocumentController.java # Inventory management
│       │               ├── H2DbConnection.java        # Database connection
│       │               ├── DbConnection.java          # Legacy MySQL connection
│       │               ├── AlertDialog.java           # Custom alert dialogs
│       │               └── NameList.java             # Data model
│       └── resources/
│           ├── login.fxml                           # Login screen
│           ├── overview.fxml                        # Dashboard
│           ├── FXMLDocument.fxml                    # Inventory management
│           ├── invoice.fxml                         # Invoice creation
│           ├── restock.fxml                         # Restock management
│           └── design.css                           # Application styling
├── pom.xml                                          # Maven configuration
├── database_setup.sql                               # Database schema
├── run.sh                                           # Run script
└── README.md                                        # This file
```

## 🎨 UI Features

### Login Screen
- Compact, modern design (500x380px)
- Coffee-themed styling
- Secure authentication

### Dashboard
- Clean, organized layout (800x600px)
- Easy navigation to all features
- Professional coffee shop branding

### Inventory Management
- Add new products
- Update existing products
- Search functionality
- Real-time stock tracking

## 🔧 Configuration

### Database
The application uses H2 in-memory database by default. The database schema is automatically created on first run.

### Window Sizes
- Login: 500x380px
- Dashboard: 800x600px
- Inventory: 1400x800px
- Other screens: 500x350px

## 🐛 Troubleshooting

### Common Issues

1. **JavaFX not found**
   - Ensure you have Java 8+ installed
   - Check that JAVA_HOME is set correctly

2. **Maven build fails**
   - Run `mvn clean` then `mvn compile`
   - Check Java version compatibility

3. **Database connection issues**
   - The H2 database is in-memory and requires no setup
   - Check that the application has write permissions

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👥 Authors

- **Your Name** - *Initial work* - [YourGitHub](https://github.com/yourusername)

## 🙏 Acknowledgments

- JavaFX community for the excellent UI framework
- H2 Database for the lightweight database solution
- Coffee community for inspiration

## 📞 Support

If you encounter any issues or have questions, please:
1. Check the troubleshooting section above
2. Search existing issues
3. Create a new issue with detailed information

---

**Enjoy managing your coffee shop! ☕** 