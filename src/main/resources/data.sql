INSERT INTO car_body (id, count, type) VALUES (1, 10, 'хэтчбек') ON CONFLICT (id) DO NOTHING
INSERT INTO car_body (id, count, type) VALUES (2, 10, 'седан') ON CONFLICT (id) DO NOTHING

INSERT INTO car_wheel (id, count, size) VALUES (1, 20, 'R15') ON CONFLICT (id) DO NOTHING
INSERT INTO car_wheel (id, count, size) VALUES (2, 20, 'R16') ON CONFLICT (id) DO NOTHING
INSERT INTO car_wheel (id, count, size) VALUES (3, 20, 'R17') ON CONFLICT (id) DO NOTHING