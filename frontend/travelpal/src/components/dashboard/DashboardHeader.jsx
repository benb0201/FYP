import { MdPostAdd } from "react-icons/md";

import "./DashboardHeader.css";

function DashboardHeader({ clientName }) {
  return (
    <header className="header">
      <h1>{clientName ? `${clientName}'s Dashboard` : "Dashboard"}</h1>
    </header>
  );
}

export default DashboardHeader;
