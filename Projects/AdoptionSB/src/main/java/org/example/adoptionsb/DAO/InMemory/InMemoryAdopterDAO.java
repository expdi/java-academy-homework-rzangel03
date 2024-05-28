package org.example.adoptionsb.DAO.InMemory;

public class InMemoryAdopterDAO {

//    private Map<Integer, Adopter> adopterMap = new HashMap<>();
//    private int nextId = 1;
//
//    @Override
//    public Adopter insert(Adopter adopter) {
//        int id = nextId++;
//        adopter.setIdAdopter(id);
//        adopter.setAdopterName("InMem: " + adopter.getAdopterName());
//        adopterMap.put(adopter.getIdAdopter(), adopter);
//        return adopter;
//    }
//
//    @Override
//    public boolean delete(int id) {
//        return adopterMap.remove(id) != null;
//    }
//
//    @Override
//    public boolean update(Adopter adopter) {
//        return adopterMap.replace(adopter.getIdAdopter(), adopter) != null;
//    }
//
//    @Override
//    public Adopter findById(int id) {
//        return adopterMap.get(id);
//    }
//
//    @Override
//    public List<Adopter> findAll() {
//        return new ArrayList<>(adopterMap.values());
//    }
//
//    @Override
//    public List<String> getAdoptersByName() {
//        return adopterMap.values().stream().map(Adopter::getAdopterName).toList();
//    }
//
//    @Override
//    public List<Adopter> getAdoptersByNameSorted() {
//        return adopterMap.values().stream().sorted(Comparator.comparing(Adopter::getAdopterName)).toList();
//    }
//
//    @Override
//    public List<Adopter> getAdoptersByDateSorted() {
//        return adopterMap.values().stream().sorted(Comparator.comparing(Adopter::getAdoptionDate)).toList();
//    }
}
