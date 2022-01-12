package enumaration;

public enum TransactionTypes {
    ADD(1) {
        public String toString() {
            return "id: 1, type: add";
        }
    },
    SALE(2) {
        public String toString() {
            return "id: 2, type: sale";
        }
    },
    UPDATE(3) {
        public String toString() { return "id: 3, type: update"; }
    },
    DELETE(4) {
        public String toString() { return "id: 4, type: delete"; }
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
