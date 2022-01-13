package enumaration;

public enum TransactionTypes {
    ADD(1) {
        public String toString() {
            return "add";
        }
    },
    SALE(2) {
        public String toString() {
            return "sale";
        }
    },
    UPDATE(3) {
        public String toString() { return "update"; }
    },
    DELETE(4) {
        public String toString() { return "delete"; }
    };

    private final int id;

    TransactionTypes(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static TransactionTypes getById(int id) {
        for (TransactionTypes type : values()) {
            if (type.id == (id)) {
                return type;
            }
        }
        return null;
    }

}
