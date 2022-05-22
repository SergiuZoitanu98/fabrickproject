package com.example.fabrickproject.models;

public class TaxRelief {
    private String creditorFiscalCode;
    private String beneficiaryType;
private boolean isCondoUpgrade;

    public boolean isCondoUpgrade() {
        return isCondoUpgrade;
    }

    public void setCondoUpgrade(boolean condoUpgrade) {
        isCondoUpgrade = condoUpgrade;
    }
private LegalPersonBeneficiary legalPersonBeneficiary;

    public LegalPersonBeneficiary getLegalPersonBeneficiary() {
        return legalPersonBeneficiary;
    }

    public void setLegalPersonBeneficiary(LegalPersonBeneficiary legalPersonBeneficiary) {
        this.legalPersonBeneficiary = legalPersonBeneficiary;
    }

    private NaturalPersonBeneficiary naturalPersonBeneficiary;

    public NaturalPersonBeneficiary getNaturalPersonBeneficiary() {
        return naturalPersonBeneficiary;
    }

    public void setNaturalPersonBeneficiary(NaturalPersonBeneficiary naturalPersonBeneficiary) {
        this.naturalPersonBeneficiary = naturalPersonBeneficiary;
    }

    public String getCreditorFiscalCode() {
        return creditorFiscalCode;
    }

    public void setCreditorFiscalCode(String creditorFiscalCode) {
        this.creditorFiscalCode = creditorFiscalCode;
    }

    public String getBeneficiaryType() {
        return beneficiaryType;
    }

    public void setBeneficiaryType(String beneficiaryType) {
        this.beneficiaryType = beneficiaryType;
    }
}
