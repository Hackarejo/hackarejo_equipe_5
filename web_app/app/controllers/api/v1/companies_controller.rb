module Api
  module V1
    class CompaniesController < ApplicationController
      before_action :set_company, only: [:show, :update, :destroy]

      def index
        @companies = Company.all

        respond_with @companies
      end

      def show
        respond_with @company
      end

      def create
        @company = Company.new(company_params)
        @company.save

        respond_with :api, :v1, @company
      end

      def update
        @company.update(company_params)

        respond_with :api, :v1, @company
      end

      def destroy
        @company.destroy
        
        respond_with :api, :v1, @company
      end

      private

      def set_company
        @company = Company.find(params[:id])
      end

      def company_params
        params.require(:company).permit(:responsible_id, :name, :phone, :latitude, :longitude)
      end
    end
  end
end