import java.util.*;


public class Main {
    public static class Team {
        private String name;
        private String creator;
        private List<String> members;

        public Team(String name, String creator) {
            this.name = name;
            this.creator = creator;
            this.members = new ArrayList<>();
        }


        public String getName() {
            return name;
        }

        public String getCreator() {
            return creator;
        }

        public List<String> getMembers() {
            return members;
        }

        public void addMember(String member) {
            this.members.add(member);
        }

        public int getMemberCount() {
            return this.members.size();
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setCreator(String creator) {
            this.creator = creator;
        }

        public void setMembers(List<String> members) {
            this.members = members;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(name).append("\n");
            sb.append("- ").append(creator).append("\n");
            for (String member : members) {
                sb.append("-- ").append(member).append("\n");
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int teamCount = Integer.parseInt(scanner.nextLine());
        Map<String, Team> teams = new HashMap<>();
        Set<String> users = new HashSet<>();

        for (int i = 0; i < teamCount; i++) {
            String[] teamInfo = scanner.nextLine().split("-");
            String user = teamInfo[0];
            String teamName = teamInfo[1];

            if (teams.containsKey(teamName)) {
                System.out.printf("Team %s was already created!%n", teamName);
            } else if (users.contains(user)) {
                System.out.printf("%s cannot create another team!%n", user);
            } else {
                Team team = new Team(teamName, user);
                teams.put(teamName, team);
                users.add(user);
                System.out.printf("Team %s has been created by %s!%n", teamName, user);
            }
        }


        String line = scanner.nextLine();
        while (!line.equals("end of assignment")) {
            String[] joinInfo = line.split("->");
            String user = joinInfo[0];
            String teamName = joinInfo[1];

            if (!teams.containsKey(teamName)) {
                System.out.printf("Team %s does not exist!%n", teamName);
            } else {
                boolean alreadyInTeam = teams.values().stream().anyMatch(t -> t.getMembers().contains(user) || t.getCreator().equals(user));

                if (alreadyInTeam) {
                    System.out.printf("Member %s cannot join team %s!%n", user, teamName);
                } else {
                    teams.get(teamName).addMember(user);
                }
            }

            line = scanner.nextLine();
        }


        List<Team> activeTeams = new ArrayList<>();
        List<String> disbandTeams = new ArrayList<>();

        for (Team team : teams.values()) {
            if (team.getMemberCount() > 0) {
                activeTeams.add(team);
            } else {
                disbandTeams.add(team.getName());
            }
        }


        activeTeams.sort(Comparator.comparing(Team::getMemberCount).reversed().thenComparing(Team::getName));

        for (Team team : activeTeams) {
            team.getMembers().sort(String::compareTo);
            System.out.println(team);
        }


        System.out.println("Teams to disband:");
        disbandTeams.sort(String::compareTo);
        for (String teamName : disbandTeams) {
            System.out.println(teamName);
        }
    }
}
