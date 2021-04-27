This project is build on spring boot with spring data JPA as persistence and H2 as in-memory db, with form login in spring security
and thymeleaf as frontend.
The Blood bank is a project that has two roles: admin and user.
Admin:
     ->Can register the donor.
     ->Can view the list of all donors.
     ->can delete any donor.
     ->can search a donor by name.
     ->can update any donor info.
     ->can view a details of any donor.

Donor:
     ->can register itself.
     ->can update itself.
     ->can view list of all donors.
     ->can view details of any donor.
     ->can search by name.
     ->can't assign any role.
     ->can delete its account.