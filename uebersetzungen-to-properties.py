with open("uebersetzungen.csv") as file:
    for line in file:
        words = line.split(";")
        if words[0] == "propertyname":
            for i in range(len(words)-1):
                languages = words[1:]
                open("src/main/resources/messages_" + words[i+1].strip() + ".properties", "w")
            continue
        
        if not words[0].startswith("\n") and not words[0].startswith("#") and len(words) != 0:
            for i, l in enumerate(languages):
                f = open("src/main/resources/messages_" + l.strip() + ".properties", "a")
                f.write(words[0] + "=" + words[i] + "\n")

