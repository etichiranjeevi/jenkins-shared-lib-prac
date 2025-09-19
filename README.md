# Jenkins Shared Library Practice Example (Complete)

This repository demonstrates:

- A verbose Jenkins pipeline written in one Jenkinsfile (`old.Jenkinsfile`).
- A cleaner Jenkins pipeline using a Jenkins Shared Library (`new.Jenkinsfile`).
- Shared library steps under `vars/` and helper classes under `src/`.
- Dummy scripts included so pipelines run without errors.

## Usage

1. Add this repo as a shared library in Jenkins (Manage Jenkins > Configure System > Global Pipeline Libraries).
2. Run `old.Jenkinsfile` pipeline job to see verbose, duplicated steps.
3. Run `new.Jenkinsfile` pipeline job to see cleaner code using shared library.

