package com.regres.testdata;

import java.util.Comparator;

public class UserForSerchTableTest {
    String status;
    String firstName;
    String lastName;
    String login;
    String territorialCommunityName;
    String email;
    String role_type;
    String button;


    @Override
    public String toString() {
        return "User{" +
                "status='" + status + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", territorialCommunity_name='" + territorialCommunityName + '\'' +
                ", email='" + email + '\'' +
                ", role_type='" + role_type + '\'' +
                ", button='" + button + '\'' +
                '}';
    }

    public UserForSerchTableTest(String status, String firstName, String lastName, String login, String territorialCommunityName, String email, String role_type, String button) {
        this.status = status;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.territorialCommunityName = territorialCommunityName;
        this.email = email;
        this.role_type = role_type;
        this.button = button;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getTerritorialCommunityName() {
        return territorialCommunityName;
    }

    public void setTerritorialCommunity_name(String territorialCommunity_name) {
        this.territorialCommunityName = territorialCommunity_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole_type() {
        return role_type;
    }

    public void setRole_type(String role_type) {
        this.role_type = role_type;
    }

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserForSerchTableTest user = (UserForSerchTableTest) o;

        if (!status.equals(user.status)) return false;
        if (!firstName.equals(user.firstName)) return false;
        if (!lastName.equals(user.lastName)) return false;
        if (!login.equals(user.login)) return false;
        if (!territorialCommunityName.equals(user.territorialCommunityName)) return false;
        if (!email.equals(user.email)) return false;
        return role_type.equals(user.role_type);
    }

    @Override
    public int hashCode() {
        int result = status.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + login.hashCode();
        result = 31 * result + territorialCommunityName.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + role_type.hashCode();
        return result;
    }

    //methods

    public static Comparator<UserForSerchTableTest> userFirstNameComparatorASC = new Comparator<UserForSerchTableTest>() {
        public int compare(UserForSerchTableTest s1, UserForSerchTableTest s2) {
            return s1.firstName.compareToIgnoreCase(s2.firstName);
        }
    };

    public static Comparator<UserForSerchTableTest> userFirstNameComparatorDESC = new Comparator<UserForSerchTableTest>() {
        public int compare(UserForSerchTableTest s1, UserForSerchTableTest s2) {
            return s2.firstName.compareToIgnoreCase(s1.firstName);
        }
    };
    public static Comparator<UserForSerchTableTest> userLastNameComparatorASC = new Comparator<UserForSerchTableTest>() {
        public int compare(UserForSerchTableTest s1, UserForSerchTableTest s2) {
            return s1.lastName.compareToIgnoreCase(s2.lastName);
        }
    };

    public static Comparator<UserForSerchTableTest> userLastNameComparatorDESC = new Comparator<UserForSerchTableTest>() {
        public int compare(UserForSerchTableTest s1, UserForSerchTableTest s2) {
            return s2.lastName.compareToIgnoreCase(s1.lastName);
        }
    };
    public static Comparator<UserForSerchTableTest> userCommunityNameComparatorASC = new Comparator<UserForSerchTableTest>() {
        public int compare(UserForSerchTableTest s1, UserForSerchTableTest s2) {
            return s1.territorialCommunityName.compareToIgnoreCase(s2.territorialCommunityName);
        }
    };

    public static Comparator<UserForSerchTableTest> userCommunityNameComparatorDESC = new Comparator<UserForSerchTableTest>() {
        public int compare(UserForSerchTableTest s1, UserForSerchTableTest s2) {
            return s2.territorialCommunityName.compareToIgnoreCase(s1.territorialCommunityName);
        }
    };
    public static Comparator<UserForSerchTableTest> userLoginComparatorASC = new Comparator<UserForSerchTableTest>() {
        public int compare(UserForSerchTableTest s1, UserForSerchTableTest s2) {
            return s1.login.compareToIgnoreCase(s2.login);
        }
    };

    public static Comparator<UserForSerchTableTest> userLoginComparatorDESC = new Comparator<UserForSerchTableTest>() {
        public int compare(UserForSerchTableTest s1, UserForSerchTableTest s2) {
            return s2.login.compareToIgnoreCase(s1.login);
        }
    };
}
