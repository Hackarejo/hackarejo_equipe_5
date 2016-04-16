module Api
  module V1
    class OffersController < ApplicationController
      before_action :set_offer, only: [:show, :update, :destroy]

      def index
        @offers = Offer.all

        respond_with @offers
      end

      def show
        respond_with @offer
      end

      def create
        @offer = Offer.new(offer_params)
        @offer.save

        respond_with :api, :v1, @offer
      end

      def update
        @offer.update(offer_params)

        respond_with :api, :v1, @offer
      end

      def destroy
        @offer.destroy
        
        respond_with :api, :v1, @offer
      end

      private

      def set_offer
        @offer = Offer.find(params[:id])
      end

      def offer_params
        params.require(:offer).permit(:company_id, :title, :description, :due_date)
      end
    end
  end
end