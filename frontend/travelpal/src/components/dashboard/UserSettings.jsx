import React, { useState } from "react";
import styles from "./UserSettings.module.css";

const UserSettings = () => {
  const [notificationsEnabled, setNotificationsEnabled] = useState(false);
  const [theme, setTheme] = useState("light");

  const handleNotificationChange = () => {
    setNotificationsEnabled(!notificationsEnabled);
  };

  const handleThemeChange = (event) => {
    setTheme(event.target.value);
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    alert(
      `Settings updated:\n- Notifications: ${
        notificationsEnabled ? "Enabled" : "Disabled"
      }\n- Theme: ${theme}`
    );
  };

  return (
    <div className={styles.greetingWrapper}>
      <h2 className={styles.heading}>User Settings</h2>
      <div className={styles.settingsWrapper}>
        <form onSubmit={handleSubmit} className={styles.settingsForm}>
          <section className={styles.settingSection}>
            <h3>Notifications</h3>
            <label className={styles.switch}>
              <input
                type="checkbox"
                checked={notificationsEnabled}
                onChange={handleNotificationChange}
              />
              <span className={styles.slider}></span>
            </label>
          </section>
          <section className={styles.settingSection}>
            <h3>Theme</h3>
            <select
              value={theme}
              onChange={handleThemeChange}
              className={styles.themeSelect}
            >
              <option value="light">Light</option>
              <option value="dark">Dark</option>
            </select>
          </section>
          <button type="submit" className={styles.btnSave}>
            Save Settings
          </button>
        </form>
      </div>
    </div>
  );
};

export default UserSettings;
