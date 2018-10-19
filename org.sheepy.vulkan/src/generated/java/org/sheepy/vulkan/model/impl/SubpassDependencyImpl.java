/**
 */
package org.sheepy.vulkan.model.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.sheepy.vulkan.model.SubpassDependency;
import org.sheepy.vulkan.model.VulkanPackage;

import org.sheepy.vulkan.model.enumeration.EPipelineStage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subpass Dependency</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.impl.SubpassDependencyImpl#getSrcSubpass <em>Src Subpass</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.impl.SubpassDependencyImpl#getDstSubpass <em>Dst Subpass</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.impl.SubpassDependencyImpl#getSrcStageMask <em>Src Stage Mask</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.impl.SubpassDependencyImpl#getDstStageMask <em>Dst Stage Mask</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.impl.SubpassDependencyImpl#getSrcAccessMask <em>Src Access Mask</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.impl.SubpassDependencyImpl#getDstAccessMask <em>Dst Access Mask</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SubpassDependencyImpl extends MinimalEObjectImpl.Container implements SubpassDependency
{
	/**
	 * The default value of the '{@link #getSrcSubpass() <em>Src Subpass</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrcSubpass()
	 * @generated
	 * @ordered
	 */
	protected static final int SRC_SUBPASS_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getSrcSubpass() <em>Src Subpass</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrcSubpass()
	 * @generated
	 * @ordered
	 */
	protected int srcSubpass = SRC_SUBPASS_EDEFAULT;

	/**
	 * The default value of the '{@link #getDstSubpass() <em>Dst Subpass</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDstSubpass()
	 * @generated
	 * @ordered
	 */
	protected static final int DST_SUBPASS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDstSubpass() <em>Dst Subpass</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDstSubpass()
	 * @generated
	 * @ordered
	 */
	protected int dstSubpass = DST_SUBPASS_EDEFAULT;

	/**
	 * The default value of the '{@link #getSrcStageMask() <em>Src Stage Mask</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrcStageMask()
	 * @generated
	 * @ordered
	 */
	protected static final EPipelineStage SRC_STAGE_MASK_EDEFAULT = EPipelineStage.COLOR_ATTACHMENT_OUTPUT_BIT;

	/**
	 * The cached value of the '{@link #getSrcStageMask() <em>Src Stage Mask</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrcStageMask()
	 * @generated
	 * @ordered
	 */
	protected EPipelineStage srcStageMask = SRC_STAGE_MASK_EDEFAULT;

	/**
	 * The default value of the '{@link #getDstStageMask() <em>Dst Stage Mask</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDstStageMask()
	 * @generated
	 * @ordered
	 */
	protected static final EPipelineStage DST_STAGE_MASK_EDEFAULT = EPipelineStage.COLOR_ATTACHMENT_OUTPUT_BIT;

	/**
	 * The cached value of the '{@link #getDstStageMask() <em>Dst Stage Mask</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDstStageMask()
	 * @generated
	 * @ordered
	 */
	protected EPipelineStage dstStageMask = DST_STAGE_MASK_EDEFAULT;

	/**
	 * The default value of the '{@link #getSrcAccessMask() <em>Src Access Mask</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrcAccessMask()
	 * @generated
	 * @ordered
	 */
	protected static final int SRC_ACCESS_MASK_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSrcAccessMask() <em>Src Access Mask</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrcAccessMask()
	 * @generated
	 * @ordered
	 */
	protected int srcAccessMask = SRC_ACCESS_MASK_EDEFAULT;

	/**
	 * The default value of the '{@link #getDstAccessMask() <em>Dst Access Mask</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDstAccessMask()
	 * @generated
	 * @ordered
	 */
	protected static final int DST_ACCESS_MASK_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDstAccessMask() <em>Dst Access Mask</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDstAccessMask()
	 * @generated
	 * @ordered
	 */
	protected int dstAccessMask = DST_ACCESS_MASK_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubpassDependencyImpl()
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
		return VulkanPackage.Literals.SUBPASS_DEPENDENCY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSrcSubpass()
	{
		return srcSubpass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSrcSubpass(int newSrcSubpass)
	{
		int oldSrcSubpass = srcSubpass;
		srcSubpass = newSrcSubpass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanPackage.SUBPASS_DEPENDENCY__SRC_SUBPASS, oldSrcSubpass, srcSubpass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDstSubpass()
	{
		return dstSubpass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDstSubpass(int newDstSubpass)
	{
		int oldDstSubpass = dstSubpass;
		dstSubpass = newDstSubpass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanPackage.SUBPASS_DEPENDENCY__DST_SUBPASS, oldDstSubpass, dstSubpass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPipelineStage getSrcStageMask()
	{
		return srcStageMask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSrcStageMask(EPipelineStage newSrcStageMask)
	{
		EPipelineStage oldSrcStageMask = srcStageMask;
		srcStageMask = newSrcStageMask == null ? SRC_STAGE_MASK_EDEFAULT : newSrcStageMask;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanPackage.SUBPASS_DEPENDENCY__SRC_STAGE_MASK, oldSrcStageMask, srcStageMask));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPipelineStage getDstStageMask()
	{
		return dstStageMask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDstStageMask(EPipelineStage newDstStageMask)
	{
		EPipelineStage oldDstStageMask = dstStageMask;
		dstStageMask = newDstStageMask == null ? DST_STAGE_MASK_EDEFAULT : newDstStageMask;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanPackage.SUBPASS_DEPENDENCY__DST_STAGE_MASK, oldDstStageMask, dstStageMask));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSrcAccessMask()
	{
		return srcAccessMask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSrcAccessMask(int newSrcAccessMask)
	{
		int oldSrcAccessMask = srcAccessMask;
		srcAccessMask = newSrcAccessMask;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanPackage.SUBPASS_DEPENDENCY__SRC_ACCESS_MASK, oldSrcAccessMask, srcAccessMask));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDstAccessMask()
	{
		return dstAccessMask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDstAccessMask(int newDstAccessMask)
	{
		int oldDstAccessMask = dstAccessMask;
		dstAccessMask = newDstAccessMask;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanPackage.SUBPASS_DEPENDENCY__DST_ACCESS_MASK, oldDstAccessMask, dstAccessMask));
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
			case VulkanPackage.SUBPASS_DEPENDENCY__SRC_SUBPASS:
				return getSrcSubpass();
			case VulkanPackage.SUBPASS_DEPENDENCY__DST_SUBPASS:
				return getDstSubpass();
			case VulkanPackage.SUBPASS_DEPENDENCY__SRC_STAGE_MASK:
				return getSrcStageMask();
			case VulkanPackage.SUBPASS_DEPENDENCY__DST_STAGE_MASK:
				return getDstStageMask();
			case VulkanPackage.SUBPASS_DEPENDENCY__SRC_ACCESS_MASK:
				return getSrcAccessMask();
			case VulkanPackage.SUBPASS_DEPENDENCY__DST_ACCESS_MASK:
				return getDstAccessMask();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case VulkanPackage.SUBPASS_DEPENDENCY__SRC_SUBPASS:
				setSrcSubpass((Integer)newValue);
				return;
			case VulkanPackage.SUBPASS_DEPENDENCY__DST_SUBPASS:
				setDstSubpass((Integer)newValue);
				return;
			case VulkanPackage.SUBPASS_DEPENDENCY__SRC_STAGE_MASK:
				setSrcStageMask((EPipelineStage)newValue);
				return;
			case VulkanPackage.SUBPASS_DEPENDENCY__DST_STAGE_MASK:
				setDstStageMask((EPipelineStage)newValue);
				return;
			case VulkanPackage.SUBPASS_DEPENDENCY__SRC_ACCESS_MASK:
				setSrcAccessMask((Integer)newValue);
				return;
			case VulkanPackage.SUBPASS_DEPENDENCY__DST_ACCESS_MASK:
				setDstAccessMask((Integer)newValue);
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
			case VulkanPackage.SUBPASS_DEPENDENCY__SRC_SUBPASS:
				setSrcSubpass(SRC_SUBPASS_EDEFAULT);
				return;
			case VulkanPackage.SUBPASS_DEPENDENCY__DST_SUBPASS:
				setDstSubpass(DST_SUBPASS_EDEFAULT);
				return;
			case VulkanPackage.SUBPASS_DEPENDENCY__SRC_STAGE_MASK:
				setSrcStageMask(SRC_STAGE_MASK_EDEFAULT);
				return;
			case VulkanPackage.SUBPASS_DEPENDENCY__DST_STAGE_MASK:
				setDstStageMask(DST_STAGE_MASK_EDEFAULT);
				return;
			case VulkanPackage.SUBPASS_DEPENDENCY__SRC_ACCESS_MASK:
				setSrcAccessMask(SRC_ACCESS_MASK_EDEFAULT);
				return;
			case VulkanPackage.SUBPASS_DEPENDENCY__DST_ACCESS_MASK:
				setDstAccessMask(DST_ACCESS_MASK_EDEFAULT);
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
			case VulkanPackage.SUBPASS_DEPENDENCY__SRC_SUBPASS:
				return srcSubpass != SRC_SUBPASS_EDEFAULT;
			case VulkanPackage.SUBPASS_DEPENDENCY__DST_SUBPASS:
				return dstSubpass != DST_SUBPASS_EDEFAULT;
			case VulkanPackage.SUBPASS_DEPENDENCY__SRC_STAGE_MASK:
				return srcStageMask != SRC_STAGE_MASK_EDEFAULT;
			case VulkanPackage.SUBPASS_DEPENDENCY__DST_STAGE_MASK:
				return dstStageMask != DST_STAGE_MASK_EDEFAULT;
			case VulkanPackage.SUBPASS_DEPENDENCY__SRC_ACCESS_MASK:
				return srcAccessMask != SRC_ACCESS_MASK_EDEFAULT;
			case VulkanPackage.SUBPASS_DEPENDENCY__DST_ACCESS_MASK:
				return dstAccessMask != DST_ACCESS_MASK_EDEFAULT;
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
		result.append(" (srcSubpass: ");
		result.append(srcSubpass);
		result.append(", dstSubpass: ");
		result.append(dstSubpass);
		result.append(", srcStageMask: ");
		result.append(srcStageMask);
		result.append(", dstStageMask: ");
		result.append(dstStageMask);
		result.append(", srcAccessMask: ");
		result.append(srcAccessMask);
		result.append(", dstAccessMask: ");
		result.append(dstAccessMask);
		result.append(')');
		return result.toString();
	}

} //SubpassDependencyImpl
