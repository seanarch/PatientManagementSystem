import React, { useState } from "react";
import SearchIcon from "@material-ui/icons/Search";
import CloseIcon from "@material-ui/icons/Close";

// Init patient information 
const data = [
    {
        id: 1,
        LastName: "Doe",
        Firstname: "John",
        Sex: "M",
        Birthday: "Jan 1, 1980",
        ULI: "1",
        Print: true,
        TG: "TG",
        Location: "Location"
    },
    {
        id: 2,
        LastName: "Smith",
        Firstname: "Stanley",
        Sex: "M",
        Birthday: "Jan 2, 1980",
        ULI: "2",
        Print: true,
        TG: "TG",
        Location: "Location"
    },
    {
        id: 3,
        LastName: "Doe",
        Firstname: "Jane",
        Sex: "F",
        Birthday: "Jan 3, 1980",
        ULI: "3",
        Print: false,
        TG: "TG",
        Location: "Location"
    },
    {
        id: 4,
        LastName: "Z",
        Firstname: "Olivia",
        Sex: "M",
        Birthday: "Jan 1, 1980",
        ULI: "4",
        Print: false,
        TG: "TG",
        Location: "Location"
    },
    {
        id: 5,
        LastName: "X",
        Firstname: "Emma",
        Sex: "M",
        Birthday: "Jan 1, 1980",
        ULI: "5",
        Print: true,
        TG: "TG",
        Location: "Location"
    },
];

function Previsit_search({ placeholder, data }) {
    const [filteredData, setFilteredData] = useState([]);
    const [wordEntered, setWordEntered] = useState("");

    const handleFilter = (event) => {
        const searchWord = event.target.value;
        setWordEntered(searchWord);
        const newFilter = data.filter((value) => {
            return value.title.toLowerCase().includes(searchWord.toLowerCase());
        });

        if (searchWord === "") {
            setFilteredData([]);
        } else {
            setFilteredData(newFilter);
        }
    };

    const clearInput = () => {
        setFilteredData([]);
        setWordEntered("");
    };

    return (
        <div className="search">
            <div className="searchInputs">
                <input
                    type="text"
                    placeholder={placeholder}
                    value={wordEntered}
                    onChange={handleFilter}
                />
                <div className="searchIcon">
                    {filteredData.length === 0 ? (
                        <SearchIcon />
                    ) : (
                        <CloseIcon id="clearBtn" onClick={clearInput} />
                    )}
                </div>
            </div>
            {filteredData.length != 0 && (
                <div className="dataResult">
                    {filteredData.slice(0, 15).map((value, key) => {
                        return (
                            <a className="dataItem" href={value.link} target="_blank">
                                <p>{value.title} </p>
                            </a>
                        );
                    })}
                </div>
            )}
        </div>
    );
}

export default Previsit_search;