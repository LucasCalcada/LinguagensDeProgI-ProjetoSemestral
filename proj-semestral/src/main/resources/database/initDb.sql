CREATE TABLE IF NOT EXISTS rooms (
    id INTEGER AUTO_INCREMENT,
    room_name VARCHAR(255) NOT NULL,
    daily_rate INTEGER CHECK (daily_rate >= 0),
    single_bed_count INTEGER,
    double_bed_count INTEGER,
    status ENUM ("FREE", "OCCUPIED", "MAINTENANCE"),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS bookings (
    id INTEGER AUTO_INCREMENT,
    room INTEGER,
    booker_name VARCHAR(255) NOT NULL,
    booker_cpf VARCHAR(11) NOT NULL,
    booker_phone VARCHAR(14) NOT NULL,
    client_count INTEGER,
    booking_start DATETIME,
    booking_end DATETIME,
    PRIMARY KEY (id),
    FOREIGN KEY (room) REFERENCES rooms (id)
);

CREATE TABLE IF NOT EXISTS products (
    id INTEGER AUTO_INCREMENT,
    product_name VARCHAR(255) NOT NULL,
    sell_price INTEGER NOT NULL CHECK (sell_price >= 0),
    active BOOLEAN NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS sales (
    id INTEGER AUTO_INCREMENT,
    product INTEGER NOT NULL,
    amount INTEGER NOT NULL CHECK (amount >= 0),
    price INTEGER NOT NULL CHECK (price >= 0),
    booking INTEGER NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (product) REFERENCES products (id),
    FOREIGN KEY (booking) REFERENCES bookings (id)
);

CREATE TABLE IF NOT EXISTS storage_entries (
    id INTEGER AUTO_INCREMENT,
    product INTEGER NOT NULL,
    entry_type ENUM ("IN", "OUT") NOT NULL,
    amount INTEGER NOT NULL CHECK (amount > 0),
    PRIMARY KEY (id),
    FOREIGN KEY (product) REFERENCES products (id)
);
