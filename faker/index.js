
const fetch = require('cross-fetch');
const { faker } = require('@faker-js/faker');

faker.locale = 'pt_BR'

function salvar(quantidade) {

    for (let i = 0; i < quantidade; i++) {

        var caracteresFone = faker.phone.phoneNumber('+55 (##) ####-####').split(' ');

        let phone = {
            ddi: caracteresFone[0],
            ddd: caracteresFone[1],
            number: caracteresFone[2],
            phoneNumber: caracteresFone[0] + ' ' + caracteresFone[1] + ' ' + caracteresFone[2]
        }


        let address = {
            country: faker.address.country(),
            zipCode: faker.address.zipCode(),
            state: faker.address.stateAbbr(),
            city: faker.address.city(),
            street: faker.address.streetName(),
            phone: phone
        }

        const person = {
            firstName: faker.name.firstName(),
            lastName: faker.name.lastName(),
            address: address,
            birthDay: faker.date.past(10, '2000-01-01T00:00:00.000Z'),
            picture: faker.image.avatar(),
            personalEmail: faker.internet.email().toLowerCase().replace(/\s+/g, "_"),
        }

        savePerson(person);
    }
}

function savePerson(person) {
    (async () => {
        try {
            const res = await fetch("http://localhost:8080/api/v0/person", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(person),
            })
                .then((response) => { return response })
                .then((data) => {

                    return data;
                })
                .catch((error) => {
                    console.error("Error:", error);
                });

            const user = await res.json();

            if (user !== undefined) {
                let emp = {}
                if (user.id % 2 == 0) {
                    let n = getRandomInt(0, 9);
                    if (n % 2 == 0) {
                        emp = { person: user, matricula: null, corporateEmail: person.firstName.toLowerCase().replace(/\s+/g, "_") + '@sn.com', hiringDate: faker.date.past(5, '2008-01-01T00:00:00.000Z'), dismissalDate: faker.date.past(10, '2021-01-01T00:00:00.000Z') };
                    } else {
                        emp = { person: user, matricula: null, corporateEmail: person.firstName.toLowerCase().replace(/\s+/g, "_") + '@sn.com', hiringDate: faker.date.past(10, '2012-01-01T00:00:00.000Z'), dismissalDate: null };
                    }
                    saveEmployee(emp);
                }
            }
        } catch (err) {
            console.error(err);
        }
    })();
}

function saveEmployee(employee) {
    (async () => {
        try {
            const res = await fetch("http://localhost:8080/api/v0/employee", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(employee),
            })
                .then((response) => { return response })
                .then((data) => {
                    return data;
                })
                .catch((error) => {
                    console.error("Error:", error);
                    return null;
                });
        } catch (err) {
            console.error(err);
            return null;
        }
    })();
}

function getRandomInt(min, max) {
    min = Math.ceil(min);
    max = Math.floor(max);
    return Math.floor(Math.random() * (max - min)) + min;
}

//Mandando salvar a massa de dados:
 salvar(50);


(async () => {
    try {
        const res = await fetch("http://localhost:8080/api/v0/person", {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
            }
        })
            .then((response) => { return response })
            .then((data) => {
                return data;
            })
            .catch((error) => {
                console.error("Error:", error);
                return null;
            });
        const user = await res.json()

        console.log(user)
    } catch (err) {
        console.error(err);
        return null;
    }
})();
