package enumaration;

public enum Role {
  SELLER(1) {
    public String toString() {
      return "seller";
    }
  },

  ADMIN(2) {
    public String toString() {
      return "admin";
    }
  };
  private final int id;

  Role(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }


  public static Role getById(int id) {
    for (Role type : values()) {
      if (type.id == (id))
        return type;
    }

    return null;
  }

}