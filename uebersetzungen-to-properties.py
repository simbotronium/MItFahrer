with open("uebersetzungen.csv") as file:
    for line in file:
        words = line.split(";")
        if words[0] == "propertyname":
            for i in range(len(words)-1):
                open("src/main/resources/messages_" + words[i+1].strip() + ".properties", "w")
            continue
        
        if words[0].strip() != "#" and len(words) != 0:
            print(words[0], len(words))

