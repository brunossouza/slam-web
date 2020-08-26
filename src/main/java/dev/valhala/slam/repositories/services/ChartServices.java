package dev.valhala.slam.repositories.services;

import dev.valhala.slam.beans.MonthlyConsumptionChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class ChartServices {

    @Autowired
    private EntityManager manager;

    @Transactional
    public List<MonthlyConsumptionChart> getMonthlyConsumptionChart() {
        try {
            TypedQuery<MonthlyConsumptionChart> query = manager.createQuery("SELECT NEW dev.valhala.slam.beans.MonthlyConsumptionChart(AVG(m.power) , TO_CHAR(TO_DATE(TO_CHAR(EXTRACT(MONTH FROM m.createdAt),'999'), 'MM'), 'month')) FROM Measures m WHERE m.createdAt BETWEEN (CURRENT_TIMESTAMP - INTERVAL '12 MONTHS') AND CURRENT_TIMESTAMP GROUP BY TO_CHAR(TO_DATE(TO_CHAR(EXTRACT(MONTH FROM m.createdAt),'999'), 'MM'), 'month')", MonthlyConsumptionChart.class);
            List<MonthlyConsumptionChart> resultList = query.getResultList();
            return resultList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
