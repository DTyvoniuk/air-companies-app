# air-companies-app
 
 Проста симуляція системи управління авіакомпаніями. Щоб запустити проект в себе, потрібно: отримати лінк цього проекту, в ідеї натиснути File -> New -> Project from Version Control вставити туди лінк, додати параметри підключення до бази данних, все :)
 
 # Використані технології 
 - Java 11
 - Spring (Boot, Data, Web)
 - MySQL
 - Docker

  # Доступні ендпоінти 
  - GET /air-companies/{id} - отримати авіакомпанію за айді
  - PATCH /air-companies/{name}?status=status - отримати рейси за компанією і статусом 
  - GET /air-companies/active - отримати активні рейси авіакомпанії
  - POST /airplanes - додати новий літак
  - PATCH /airplanes/move?airplane_id=aId&company_id=cId - змінити компанію літака
  - POST /flights - додати новий рейс
  - PATCH /flights/{id} - змінити статус рейсу по його айді
  - GET /flights/delayed - отримати рейси, що прийшли з запізненням
