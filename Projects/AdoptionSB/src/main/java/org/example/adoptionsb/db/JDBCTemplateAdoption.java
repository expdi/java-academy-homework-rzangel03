package org.example.adoptionsb.db;

public class JDBCTemplateAdoption {
    public static void main(String[] args) {
//        JDBCTemplateAdoption jtd = new JDBCTemplateAdoption();
//        String url = "jdbc:postgresql://localhost:5433/adoptapp";
//        String user = "larku";
//        String pw = "larku";
//        DriverManagerDataSource dataSource = new DriverManagerDataSource(url, user, pw);
//        JdbcTemplate template = new JdbcTemplate(dataSource);
//        //jtd.getSimpleWithOneColumn(template);
//        jtd.addPetWithAdopter(template);
    }

//    public void getWholeObjectWithRelationShipWithResultSetExtractor(JdbcTemplate template) {
//        String sql = """
//                select a.idadopter, a.name as AdopterName, a.phonenumber, a.date,
//                p.idpet, p.name as PetName, p.type, p.breedtype
//                from adopter a
//                join pet p on a.idpet = p.idpet
//                order by a.idadopter
//                """;
//
//
//        RowMapper<AdopterPet> rowMapper = (resultSet, rowNum) -> {
//            int idadopter = resultSet.getInt("idadopter");
//            String name = resultSet.getString("AdopterName");
//            String phonenumber = resultSet.getString("phonenumber");
//            LocalDate date = resultSet.getDate("date").toLocalDate();
//            int idpet = resultSet.getInt("idpet");
//            String petName = resultSet.getString("PetName");
//            String type = resultSet.getString("type");
//            String breedtype = resultSet.getString("breedtype");
//
//            var newObj = new AdopterPet(name, phonenumber, date, petName, type, breedtype);
//            newObj.setIdAdopter(idadopter);
//            newObj.setIdPet(idpet);
//            return newObj;
//        };
//        List<AdopterPet> adopters = template.query(sql, rowMapper);
//        out.println("adopters: " + adopters);
//
//    }
//
//    public void getWholeObjectPets(JdbcTemplate template) {
//        String sql = "select * from pet";
//
//        RowMapper<Pet> rowMapper = (resultSet, rowNum) -> {
//            int idpet = resultSet.getInt("idpet");
//            String name = resultSet.getString("name");
//            String type = resultSet.getString("type");
//            String breedtype = resultSet.getString("breedtype");
//
//            var newObj = new Pet(type, name, breedtype);
//            newObj.setIdPet(idpet);
//            return newObj;
//        };
//
//        List<Pet> course = template.query(sql, rowMapper);
//
//        out.println("course: " + course);
//    }
//
//    public void getSimpleWithOneColumn(JdbcTemplate template) {
//        String sql = "select name from adopter where idadopter = ?";
//
//        String name =
//                template.queryForObject(sql, String.class, 1);
//
//        out.println("name: " + name);
//    }
//
//    public void addPetAdoption(JdbcTemplate template) {
//        String insertPetSql = "insert into pet (name, type, breedtype) values(?, ?, ?)";
//        Object[] arr = new Object[]{"Sadie", "Dog", "Bulldog"};
//
//        List<Object[]> params = new ArrayList<>();
//        params.add(arr);
//
//        int numRows = 0;
//
//        for (Object[] args : params) {
//            numRows += template.update(insertPetSql, args);
//        }
//
//        out.println("numRows: " + numRows);
//    }
//
//    public void addAdopterWithExistingPetAdoption(JdbcTemplate template) {
//        String insertSql = "insert into adopter (name, date, phonenumber,idpet) values(?, ?, ?, ?)";
//
//        Object[] arr = new Object[]{"James", LocalDate.of(2024, 05, 11), "8594785149", 3};
//        Object[] arr2 = new Object[]{"James", LocalDate.of(2024, 05, 11), "8594785149", 4};
//        Object[] arr3 = new Object[]{"James", LocalDate.of(2024, 05, 11), "8594785149", 4};
//
//        List<Object[]> params = new ArrayList<>();
//        params.add(arr);
//        params.add(arr2);
//        params.add(arr3);
//        int numRows = 0;
//
//        for (Object[] args : params) {
//            numRows += template.update(insertSql, args);
//        }
//
//        out.println("numRows: " + numRows);
//    }
//
//    public void addPetWithAdopter(JdbcTemplate template) {
//        KeyHolder keyHolder = new GeneratedKeyHolder();
//        String insertPetSql = "insert into pet (name, type, breedtype) values(?, ?, ?)";
//        template.update(con -> {
//            PreparedStatement ps = con.prepareStatement(insertPetSql, Statement.RETURN_GENERATED_KEYS);
//            ps.setString(1, "Rocky");
//            ps.setString(2, "Dog");
//            ps.setString(3, "Doberman");
//            return ps;
//        }, keyHolder);
//
//        String insertAdopterSql = "insert into adopter (name, phonenumber, date, idpet) values(?, ?, ?, ?)";
//        Object[] arr = new Object[]{"Smith", "8495781249", LocalDate.now(), keyHolder.getKeyList().getFirst().get("idpet")};
//
//        List<Object[]> params = new ArrayList<>();
//        params.add(arr);
//
//        int numRows = 0;
//
//        for (Object[] args : params) {
//            numRows += template.update(insertAdopterSql, args);
//        }
//
//        out.println("numRows: " + numRows);
//    }

}
