#!/bin/bash

# Coffee Management Store - Run Script
# This script builds and runs the Coffee Management Store application

echo "☕ Coffee Management Store - Starting up..."

# Check if Java is installed
if ! command -v java &> /dev/null; then
    echo "❌ Error: Java is not installed or not in PATH"
    echo "Please install Java 8 or higher and try again"
    exit 1
fi

# Check if Maven is installed
if ! command -v mvn &> /dev/null; then
    echo "❌ Error: Maven is not installed or not in PATH"
    echo "Please install Maven 3.6 or higher and try again"
    exit 1
fi

# Check Java version
JAVA_VERSION=$(java -version 2>&1 | head -n 1 | cut -d'"' -f2 | cut -d'.' -f1)
if [ "$JAVA_VERSION" -lt 8 ]; then
    echo "❌ Error: Java 8 or higher is required"
    echo "Current Java version: $(java -version 2>&1 | head -n 1)"
    exit 1
fi

echo "✅ Java version: $(java -version 2>&1 | head -n 1)"
echo "✅ Maven version: $(mvn -version 2>&1 | head -n 1)"

# Clean and compile
echo "🔨 Building project..."
mvn clean compile

if [ $? -ne 0 ]; then
    echo "❌ Build failed. Please check the error messages above."
    exit 1
fi

echo "✅ Build successful!"

# Run the application
echo "🚀 Starting Coffee Management Store..."
mvn javafx:run

echo "👋 Application closed. Thank you for using Coffee Management Store!" 