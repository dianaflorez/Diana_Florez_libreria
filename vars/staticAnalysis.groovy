def call(boolean abortOnQualityGate = false, boolean abortPipeline = false) {
    echo "Ejecución de las pruebas de calidad de código"
   
    
    timeout(time: 5, unit: 'MINUTES') {
        echo "Simulación de evaluación del Quality Gate"
        
        if (abortOnQualityGate) {
            echo "Quality Gate ha fallado. Abortando pipeline..."
            error("Pipeline abortado debido a fallo en Quality Gate.")
        }
    }
    
    // // Si el parámetro `abortPipeline` es true, abortar el pipeline manualmente
    // if (abortPipeline) {
    //     echo "Abortando pipeline según la configuración..."
    //     error("Pipeline abortado manualmente según el parámetro.")
    // }
    
    echo "Análisis de código completado correctamente."
}
