package gti.g55.eventichs_organisation.Domaine.Entités

import android.os.Parcel
import android.os.Parcelable

class Utilisateur (val id: Int, val nom: String, val prénom: String, val courriel: String, val motDePasse: String): Parcelable {

    constructor(parcel: Parcel): this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {

    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(nom)
        parcel.writeString(prénom)
        parcel.writeString(courriel)
        parcel.writeString(motDePasse)
    }

    companion object CREATOR: Parcelable.Creator<Utilisateur> {
        override fun createFromParcel(parcel: Parcel): Utilisateur {
            return Utilisateur(parcel)
        }

        override fun newArray(size: Int): Array<Utilisateur?> {
            return arrayOfNulls(size)
        }
    }

}