import { MdPostAdd } from "react-icons/md";

import "./DashboardHeader.css";

function DashboardHeader({ onCreatePost }) {
  return (
    <header className="header">
      <div className="greeting-wrapper">
        <h1>Dashboard</h1>
      </div>
    </header>
  );
}

export default DashboardHeader;
