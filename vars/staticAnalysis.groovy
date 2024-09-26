def call(boolean abortOnQualityGate = false, boolean abortPipeline = false) {

    def branchName = env.BRANCH_NAME ?: 'unknown'

    if (abortPipeline || branchName == 'master' || branchName.startsWith('hotfix')) {
        echo "Branch: ${branchName}. Aborting pipeline due to branch rules."
        error("Pipeline aborted due to branch rules.")
    }

    echo "Ejecución de las pruebas de calidad de código"

    sh 'echo "Ejecución de las pruebas de calidad de código"'

    timeout(time: 5, unit: 'MINUTES') {
        // Aquí iría la llamada a SonarQube, pero en este caso simulamos la ejecución
        sh 'echo "Esperando el resultado del análisis estático"'
    }

    if (abortOnQualityGate) {
        echo "Quality Gate failed. Aborting pipeline."
        error("Quality Gate failed. Pipeline aborted.")
    } else {
        echo "Quality Gate passed. Continuing pipeline."
    }

}
