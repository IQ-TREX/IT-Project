import React from 'react';
import './Sidebar.css';

function Sidebar() {
  return (
    <div className="sidebar">
      <h2>Menu</h2>
      <ul>
        <li><span>🏠</span> Home</li>
        <li><span>📚</span> Modules</li>
        <li><span>🎮</span> Games</li>
        <li><span>👥</span> Social</li>
      </ul>
    </div>
  );
}

export default Sidebar;
