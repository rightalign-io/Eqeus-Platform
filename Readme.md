# Eques - Platform

This software will be responsible foor courier services in south african independent and also usable in conjuction with other apps which need a courier service as part of theior product / service delivery.

Our competition is companies like Buffelo Couriers


## Authors

- [@Ntuthuko](https://www.github.com/octokatherine)
- [@Shaderick](https://www.github.com/octokatherine)
- [@Vukani](https://www.github.com/octokatherine)


## Roadmap

- Create the gate way proxy
- Create the Auth service and connect to proxy
- Add other service
- Create the Shell
- CReate our first MFE



1. Create the GitHub Repo: Create a new empty repository on GitHub.

2. Setup Folder Structure: Create apps/ (for your MFEs and backend services) and packages/ (for shared types or UI).

3. Install Package Manager: Initialize pnpm and create a pnpm-workspace.yaml file pointing to apps/* and packages/*.

4. Add Turborepo: Place a turbo.json file in the root to orchestrate your builds and caching.

5. Configure CI/CD: Add a GitHub Actions workflow file in .github/workflows/ci.yml using pnpm turbo run to automate building and testing on pull requests.