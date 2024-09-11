import React from 'react';
import './GoalCard.css';

function GoalCard({ title, goal, color, icon }) {
  return (
    <div className="goal-card" style={{ backgroundColor: color }}>
      <div className="goal-icon">{icon}</div>
      <h3>{title}</h3>
      <p>{goal}</p>
      <button className="play-button">▶️</button>
    </div>
  );
}

export default GoalCard;
