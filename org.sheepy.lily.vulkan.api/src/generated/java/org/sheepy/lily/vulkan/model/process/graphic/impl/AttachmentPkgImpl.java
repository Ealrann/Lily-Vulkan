/**
 */
package org.sheepy.lily.vulkan.model.process.graphic.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sheepy.lily.core.api.model.LilyEObject;

import org.sheepy.lily.vulkan.model.process.graphic.AttachmentPkg;
import org.sheepy.lily.vulkan.model.process.graphic.ExtraAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attachment Pkg</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.AttachmentPkgImpl#getExtraAttachments <em>Extra Attachments</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttachmentPkgImpl extends LilyEObject implements AttachmentPkg
{
	/**
	 * The cached value of the '{@link #getExtraAttachments() <em>Extra Attachments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtraAttachments()
	 * @generated
	 * @ordered
	 */
	protected EList<ExtraAttachment> extraAttachments;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttachmentPkgImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return GraphicPackage.Literals.ATTACHMENT_PKG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ExtraAttachment> getExtraAttachments()
	{
		if (extraAttachments == null)
		{
			extraAttachments = new EObjectContainmentEList<ExtraAttachment>(ExtraAttachment.class, this, GraphicPackage.ATTACHMENT_PKG__EXTRA_ATTACHMENTS);
		}
		return extraAttachments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case GraphicPackage.ATTACHMENT_PKG__EXTRA_ATTACHMENTS:
				return ((InternalEList<?>)getExtraAttachments()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case GraphicPackage.ATTACHMENT_PKG__EXTRA_ATTACHMENTS:
				return getExtraAttachments();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case GraphicPackage.ATTACHMENT_PKG__EXTRA_ATTACHMENTS:
				getExtraAttachments().clear();
				getExtraAttachments().addAll((Collection<? extends ExtraAttachment>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case GraphicPackage.ATTACHMENT_PKG__EXTRA_ATTACHMENTS:
				getExtraAttachments().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case GraphicPackage.ATTACHMENT_PKG__EXTRA_ATTACHMENTS:
				return extraAttachments != null && !extraAttachments.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AttachmentPkgImpl
