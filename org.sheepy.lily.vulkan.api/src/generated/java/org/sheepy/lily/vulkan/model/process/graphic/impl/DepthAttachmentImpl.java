/**
 */
package org.sheepy.lily.vulkan.model.process.graphic.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.sheepy.lily.vulkan.model.process.graphic.DepthAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.vulkan.model.enumeration.EImageUsage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Depth Attachment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.DepthAttachmentImpl#isClear <em>Clear</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.DepthAttachmentImpl#getUsages <em>Usages</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DepthAttachmentImpl extends ExtraAttachmentImpl implements DepthAttachment
{
	/**
	 * The default value of the '{@link #isClear() <em>Clear</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isClear()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CLEAR_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isClear() <em>Clear</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isClear()
	 * @generated
	 * @ordered
	 */
	protected boolean clear = CLEAR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUsages() <em>Usages</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsages()
	 * @generated
	 * @ordered
	 */
	protected EList<EImageUsage> usages;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DepthAttachmentImpl()
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
		return GraphicPackage.Literals.DEPTH_ATTACHMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isClear()
	{
		return clear;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setClear(boolean newClear)
	{
		boolean oldClear = clear;
		clear = newClear;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.DEPTH_ATTACHMENT__CLEAR, oldClear, clear));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EImageUsage> getUsages()
	{
		if (usages == null) {
			usages = new EDataTypeUniqueEList<EImageUsage>(EImageUsage.class, this, GraphicPackage.DEPTH_ATTACHMENT__USAGES);
		}
		return usages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID) {
			case GraphicPackage.DEPTH_ATTACHMENT__CLEAR:
				return isClear();
			case GraphicPackage.DEPTH_ATTACHMENT__USAGES:
				return getUsages();
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
		switch (featureID) {
			case GraphicPackage.DEPTH_ATTACHMENT__CLEAR:
				setClear((Boolean)newValue);
				return;
			case GraphicPackage.DEPTH_ATTACHMENT__USAGES:
				getUsages().clear();
				getUsages().addAll((Collection<? extends EImageUsage>)newValue);
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
		switch (featureID) {
			case GraphicPackage.DEPTH_ATTACHMENT__CLEAR:
				setClear(CLEAR_EDEFAULT);
				return;
			case GraphicPackage.DEPTH_ATTACHMENT__USAGES:
				getUsages().clear();
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
		switch (featureID) {
			case GraphicPackage.DEPTH_ATTACHMENT__CLEAR:
				return clear != CLEAR_EDEFAULT;
			case GraphicPackage.DEPTH_ATTACHMENT__USAGES:
				return usages != null && !usages.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (clear: ");
		result.append(clear);
		result.append(", usages: ");
		result.append(usages);
		result.append(')');
		return result.toString();
	}

} //DepthAttachmentImpl
