DO $$
    BEGIN
        FOR i IN 1..1000 LOOP
                INSERT INTO product (id, name, isle_type)
                VALUES (gen_random_uuid(), 'Sample Product ' || i, 'Room');
            END LOOP;
    END $$;
