module Api
  module V1
    class VouchersController < ApplicationController
      before_action :set_voucher, only: [:show, :update, :destroy]

      def index
        @vouchers = Voucher.all

        respond_with(@vouchers)
      end

      def show
        respond_with(@voucher)
      end

      def create
        @voucher = Voucher.new(voucher_params)
        @voucher.save

        respond_with :api, :v1, @voucher
      end

      def update
        @voucher.update(voucher_params)

        respond_with :api, :v1, @voucher
      end

      def destroy
        @voucher.destroy
        respond_with :api, :v1, @voucher
      end

      private

      def set_voucher
        @voucher = Voucher.find(params[:id])
      end

      def voucher_params
        params.require(:voucher).permit(:last_logged_at, :person_id)
      end
    end
  end
end
