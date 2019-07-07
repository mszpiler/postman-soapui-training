def map = new HashMap();

map.put("keyOne", "valueOne")
map.put("keyTwo", "valueTwo")
map.put("keyThree", "valueThree")

for (entry in map) {
    println entry.key + " " + entry.value
}

//more you can find here: https://www.baeldung.com/groovy-map-iterating