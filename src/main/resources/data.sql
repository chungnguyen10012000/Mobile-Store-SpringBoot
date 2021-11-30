-- SQLite
INSERT INTO User(userName, password)
VALUES (
        'admin',
        'admin'
    );
INSERT INTO Product(
        [product_name],
        product_price,
        num_in_stock,
        [description],
        manufacturer,
        category,
        condition,
        [image]
    )
VALUES (
        'P20 Pro 128GB Dual Sim Twilight',
        899,
        600,
        'A smartphone is a handheld personal computer with a mobile operating system and an integrated mobile broadband cellular network connection for voice, SMS, and Internet data communication; most, if not all, smartphones also support Wi-Fi.',
        'Huawei',
        'huawei',
        1,
        'p20-pro.jpeg'
    ),
    (
        'iPhone 8 Plus 64GB PRODUCT RED',
        1009,
        250,
        'A smartphone is a handheld personal computer with a mobile operating system and an integrated mobile broadband cellular network connection for voice, SMS, and Internet data communication; most, if not all, smartphones also support Wi-Fi.',
        'Apple',
        'apple',
        1,
        'iphone8.jpeg'
    ),
    (
        'Iphone X',
        1009,
        800,
        'A smartphone is a handheld personal computer with a mobile operating system and an integrated mobile broadband cellular network connection for voice, SMS, and Internet data communication; most, if not all, smartphones also support Wi-Fi.',
        'Apple',
        'apple',
        1,
        'iphone-x.jpg'
    ),
    (
        'Galaxy S8',
        699,
        200,
        'A smartphone is a handheld personal computer with a mobile operating system and an integrated mobile broadband cellular network connection for voice, SMS, and Internet data communication; most, if not all, smartphones also support Wi-Fi.',
        'Samsung',
        'samsung',
        1,
        'galaxy-s8.png'
    );