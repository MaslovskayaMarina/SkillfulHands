package com.example.skillfulhands.ViewModels;

import androidx.lifecycle.ViewModel;

import com.example.skillfulhands.Models.Repository;

public class MakeOrderViewModel extends ViewModel {
    private Repository repository = Repository.getInstance();
    private int approxPrice = 2000;
    private int deviceSelected = 0;
    private int problemTypeSelected = 0;
    private int promoCoeff = 0;

    public void setDeviceSelected(int deviceSelected) {
        switch (deviceSelected) {
            case 0:
                this.deviceSelected = 0;
                break;
            case 1:
                this.deviceSelected = 3000;
                break;
            case 2:
                this.deviceSelected = 2500;
                break;
            case 3:
                this.deviceSelected = 2000;
                break;
            case 4:
                this.deviceSelected = 1500;
                break;
            case 5:
                this.deviceSelected = 500;
                break;
            case 6:
                this.deviceSelected = 500;
                break;
            case 7:
                this.deviceSelected = 2200;
                break;
            default:
                break;
        }
    }

    public void setProblemTypeSelected(int problemTypeSelected) {
        switch (problemTypeSelected) {
            case 0:
                this.problemTypeSelected = 0;
                break;
            case 1:
                this.problemTypeSelected = 2300;
                break;
            case 2:
                this.problemTypeSelected = 600;
                break;
            case 3:
                this.problemTypeSelected = 700;
                break;
            case 4:
                this.problemTypeSelected = 2000;
                break;
            case 5:
                this.problemTypeSelected = 500;
                break;
            default:
                break;
        }
    }

    public void setPromo(String promo) {
        if (repository.getPromoByCode(promo) != null) {
            promoCoeff = repository.getPromoByCode(promo).getDiscountPercentage();
        } else {
            promoCoeff = 0;
        }
    }

    public int getApproxPrice() {
        int totalSum = approxPrice + this.deviceSelected + this.problemTypeSelected;
        return totalSum - (totalSum/100*promoCoeff);
    }

    public void makeOrder(
            String clientName,
            String clientPhone,
            String device,
            String problemType,
            String problemDesc,
            String master,
            String date,
            String promoCode
    ) {
        if (repository.getPromoByCode(promoCode) != null) {
            repository.CreateOrder(clientName, clientPhone, device, problemType, problemDesc, date, master, repository.getPromoByCode(promoCode));
            return;
        } else {
            repository.CreateOrder(clientName, clientPhone, device, problemType, problemDesc, date, master, repository.getPromoByCode(""));
        }
    }
}
