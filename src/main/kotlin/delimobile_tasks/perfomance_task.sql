create table parking_log(
                            id bigserial primary key not null,
                            car_plate_number varchar(12) not null,
                            parking_zone_number int not null,
                            started_at timestamptz not null,
                            finished_at timestamptz not null
);

-- ~500K records; (!) 20k cars, 1k parking zones

insert into parking_log (car_plate_number, parking_zone_number, started_at, finished_at)
values ('e111ee77', 1234, '2021-01-01T12:00:00+03:00', '2021-01-01T13:00:00+03:00');

-- ... and more records ( > 1M records); (!) 20k cars, 1k parking zones


// куда засунуть индекс

explain analyze
select 1 from parking_log
where
        parking_zone_number = 1234
  and car_plate_number = 'e111ee77'
  and (timestamptz '2021-01-01T12:30:00+03:00', timestamptz '2021-01-01T13:30:00+03:00')
    overlaps (started_at, finished_at);