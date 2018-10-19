/**
 */
package org.sheepy.vulkan.model.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.sheepy.vulkan.model.AttachmentDescription;
import org.sheepy.vulkan.model.VulkanPackage;

import org.sheepy.vulkan.model.enumeration.EAttachmentLoadOp;
import org.sheepy.vulkan.model.enumeration.EAttachmentStoreOp;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.ESampleCount;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attachment Description</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.impl.AttachmentDescriptionImpl#isStencil <em>Stencil</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.impl.AttachmentDescriptionImpl#getSamples <em>Samples</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.impl.AttachmentDescriptionImpl#getLoadOp <em>Load Op</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.impl.AttachmentDescriptionImpl#getStoreOp <em>Store Op</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.impl.AttachmentDescriptionImpl#getStencilLoadOp <em>Stencil Load Op</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.impl.AttachmentDescriptionImpl#getStencilStoreOp <em>Stencil Store Op</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.impl.AttachmentDescriptionImpl#getInitialLayout <em>Initial Layout</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.impl.AttachmentDescriptionImpl#getFinalLayout <em>Final Layout</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.impl.AttachmentDescriptionImpl#getRefLayout <em>Ref Layout</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttachmentDescriptionImpl extends MinimalEObjectImpl.Container implements AttachmentDescription
{
	/**
	 * The default value of the '{@link #isStencil() <em>Stencil</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStencil()
	 * @generated
	 * @ordered
	 */
	protected static final boolean STENCIL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isStencil() <em>Stencil</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStencil()
	 * @generated
	 * @ordered
	 */
	protected boolean stencil = STENCIL_EDEFAULT;

	/**
	 * The default value of the '{@link #getSamples() <em>Samples</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSamples()
	 * @generated
	 * @ordered
	 */
	protected static final ESampleCount SAMPLES_EDEFAULT = ESampleCount.SAMPLE_COUNT_1BIT;

	/**
	 * The cached value of the '{@link #getSamples() <em>Samples</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSamples()
	 * @generated
	 * @ordered
	 */
	protected ESampleCount samples = SAMPLES_EDEFAULT;

	/**
	 * The default value of the '{@link #getLoadOp() <em>Load Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoadOp()
	 * @generated
	 * @ordered
	 */
	protected static final EAttachmentLoadOp LOAD_OP_EDEFAULT = EAttachmentLoadOp.LOAD;

	/**
	 * The cached value of the '{@link #getLoadOp() <em>Load Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoadOp()
	 * @generated
	 * @ordered
	 */
	protected EAttachmentLoadOp loadOp = LOAD_OP_EDEFAULT;

	/**
	 * The default value of the '{@link #getStoreOp() <em>Store Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStoreOp()
	 * @generated
	 * @ordered
	 */
	protected static final EAttachmentStoreOp STORE_OP_EDEFAULT = EAttachmentStoreOp.STORE;

	/**
	 * The cached value of the '{@link #getStoreOp() <em>Store Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStoreOp()
	 * @generated
	 * @ordered
	 */
	protected EAttachmentStoreOp storeOp = STORE_OP_EDEFAULT;

	/**
	 * The default value of the '{@link #getStencilLoadOp() <em>Stencil Load Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStencilLoadOp()
	 * @generated
	 * @ordered
	 */
	protected static final EAttachmentLoadOp STENCIL_LOAD_OP_EDEFAULT = EAttachmentLoadOp.LOAD;

	/**
	 * The cached value of the '{@link #getStencilLoadOp() <em>Stencil Load Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStencilLoadOp()
	 * @generated
	 * @ordered
	 */
	protected EAttachmentLoadOp stencilLoadOp = STENCIL_LOAD_OP_EDEFAULT;

	/**
	 * The default value of the '{@link #getStencilStoreOp() <em>Stencil Store Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStencilStoreOp()
	 * @generated
	 * @ordered
	 */
	protected static final EAttachmentStoreOp STENCIL_STORE_OP_EDEFAULT = EAttachmentStoreOp.STORE;

	/**
	 * The cached value of the '{@link #getStencilStoreOp() <em>Stencil Store Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStencilStoreOp()
	 * @generated
	 * @ordered
	 */
	protected EAttachmentStoreOp stencilStoreOp = STENCIL_STORE_OP_EDEFAULT;

	/**
	 * The default value of the '{@link #getInitialLayout() <em>Initial Layout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialLayout()
	 * @generated
	 * @ordered
	 */
	protected static final EImageLayout INITIAL_LAYOUT_EDEFAULT = EImageLayout.UNDEFINED;

	/**
	 * The cached value of the '{@link #getInitialLayout() <em>Initial Layout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialLayout()
	 * @generated
	 * @ordered
	 */
	protected EImageLayout initialLayout = INITIAL_LAYOUT_EDEFAULT;

	/**
	 * The default value of the '{@link #getFinalLayout() <em>Final Layout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFinalLayout()
	 * @generated
	 * @ordered
	 */
	protected static final EImageLayout FINAL_LAYOUT_EDEFAULT = EImageLayout.UNDEFINED;

	/**
	 * The cached value of the '{@link #getFinalLayout() <em>Final Layout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFinalLayout()
	 * @generated
	 * @ordered
	 */
	protected EImageLayout finalLayout = FINAL_LAYOUT_EDEFAULT;

	/**
	 * The default value of the '{@link #getRefLayout() <em>Ref Layout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefLayout()
	 * @generated
	 * @ordered
	 */
	protected static final EImageLayout REF_LAYOUT_EDEFAULT = EImageLayout.UNDEFINED;

	/**
	 * The cached value of the '{@link #getRefLayout() <em>Ref Layout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefLayout()
	 * @generated
	 * @ordered
	 */
	protected EImageLayout refLayout = REF_LAYOUT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttachmentDescriptionImpl()
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
		return VulkanPackage.Literals.ATTACHMENT_DESCRIPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isStencil()
	{
		return stencil;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStencil(boolean newStencil)
	{
		boolean oldStencil = stencil;
		stencil = newStencil;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanPackage.ATTACHMENT_DESCRIPTION__STENCIL, oldStencil, stencil));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESampleCount getSamples()
	{
		return samples;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSamples(ESampleCount newSamples)
	{
		ESampleCount oldSamples = samples;
		samples = newSamples == null ? SAMPLES_EDEFAULT : newSamples;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanPackage.ATTACHMENT_DESCRIPTION__SAMPLES, oldSamples, samples));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttachmentLoadOp getLoadOp()
	{
		return loadOp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoadOp(EAttachmentLoadOp newLoadOp)
	{
		EAttachmentLoadOp oldLoadOp = loadOp;
		loadOp = newLoadOp == null ? LOAD_OP_EDEFAULT : newLoadOp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanPackage.ATTACHMENT_DESCRIPTION__LOAD_OP, oldLoadOp, loadOp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttachmentStoreOp getStoreOp()
	{
		return storeOp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStoreOp(EAttachmentStoreOp newStoreOp)
	{
		EAttachmentStoreOp oldStoreOp = storeOp;
		storeOp = newStoreOp == null ? STORE_OP_EDEFAULT : newStoreOp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanPackage.ATTACHMENT_DESCRIPTION__STORE_OP, oldStoreOp, storeOp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttachmentLoadOp getStencilLoadOp()
	{
		return stencilLoadOp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStencilLoadOp(EAttachmentLoadOp newStencilLoadOp)
	{
		EAttachmentLoadOp oldStencilLoadOp = stencilLoadOp;
		stencilLoadOp = newStencilLoadOp == null ? STENCIL_LOAD_OP_EDEFAULT : newStencilLoadOp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanPackage.ATTACHMENT_DESCRIPTION__STENCIL_LOAD_OP, oldStencilLoadOp, stencilLoadOp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttachmentStoreOp getStencilStoreOp()
	{
		return stencilStoreOp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStencilStoreOp(EAttachmentStoreOp newStencilStoreOp)
	{
		EAttachmentStoreOp oldStencilStoreOp = stencilStoreOp;
		stencilStoreOp = newStencilStoreOp == null ? STENCIL_STORE_OP_EDEFAULT : newStencilStoreOp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanPackage.ATTACHMENT_DESCRIPTION__STENCIL_STORE_OP, oldStencilStoreOp, stencilStoreOp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EImageLayout getInitialLayout()
	{
		return initialLayout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialLayout(EImageLayout newInitialLayout)
	{
		EImageLayout oldInitialLayout = initialLayout;
		initialLayout = newInitialLayout == null ? INITIAL_LAYOUT_EDEFAULT : newInitialLayout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanPackage.ATTACHMENT_DESCRIPTION__INITIAL_LAYOUT, oldInitialLayout, initialLayout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EImageLayout getFinalLayout()
	{
		return finalLayout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFinalLayout(EImageLayout newFinalLayout)
	{
		EImageLayout oldFinalLayout = finalLayout;
		finalLayout = newFinalLayout == null ? FINAL_LAYOUT_EDEFAULT : newFinalLayout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanPackage.ATTACHMENT_DESCRIPTION__FINAL_LAYOUT, oldFinalLayout, finalLayout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EImageLayout getRefLayout()
	{
		return refLayout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefLayout(EImageLayout newRefLayout)
	{
		EImageLayout oldRefLayout = refLayout;
		refLayout = newRefLayout == null ? REF_LAYOUT_EDEFAULT : newRefLayout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanPackage.ATTACHMENT_DESCRIPTION__REF_LAYOUT, oldRefLayout, refLayout));
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
			case VulkanPackage.ATTACHMENT_DESCRIPTION__STENCIL:
				return isStencil();
			case VulkanPackage.ATTACHMENT_DESCRIPTION__SAMPLES:
				return getSamples();
			case VulkanPackage.ATTACHMENT_DESCRIPTION__LOAD_OP:
				return getLoadOp();
			case VulkanPackage.ATTACHMENT_DESCRIPTION__STORE_OP:
				return getStoreOp();
			case VulkanPackage.ATTACHMENT_DESCRIPTION__STENCIL_LOAD_OP:
				return getStencilLoadOp();
			case VulkanPackage.ATTACHMENT_DESCRIPTION__STENCIL_STORE_OP:
				return getStencilStoreOp();
			case VulkanPackage.ATTACHMENT_DESCRIPTION__INITIAL_LAYOUT:
				return getInitialLayout();
			case VulkanPackage.ATTACHMENT_DESCRIPTION__FINAL_LAYOUT:
				return getFinalLayout();
			case VulkanPackage.ATTACHMENT_DESCRIPTION__REF_LAYOUT:
				return getRefLayout();
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
			case VulkanPackage.ATTACHMENT_DESCRIPTION__STENCIL:
				setStencil((Boolean)newValue);
				return;
			case VulkanPackage.ATTACHMENT_DESCRIPTION__SAMPLES:
				setSamples((ESampleCount)newValue);
				return;
			case VulkanPackage.ATTACHMENT_DESCRIPTION__LOAD_OP:
				setLoadOp((EAttachmentLoadOp)newValue);
				return;
			case VulkanPackage.ATTACHMENT_DESCRIPTION__STORE_OP:
				setStoreOp((EAttachmentStoreOp)newValue);
				return;
			case VulkanPackage.ATTACHMENT_DESCRIPTION__STENCIL_LOAD_OP:
				setStencilLoadOp((EAttachmentLoadOp)newValue);
				return;
			case VulkanPackage.ATTACHMENT_DESCRIPTION__STENCIL_STORE_OP:
				setStencilStoreOp((EAttachmentStoreOp)newValue);
				return;
			case VulkanPackage.ATTACHMENT_DESCRIPTION__INITIAL_LAYOUT:
				setInitialLayout((EImageLayout)newValue);
				return;
			case VulkanPackage.ATTACHMENT_DESCRIPTION__FINAL_LAYOUT:
				setFinalLayout((EImageLayout)newValue);
				return;
			case VulkanPackage.ATTACHMENT_DESCRIPTION__REF_LAYOUT:
				setRefLayout((EImageLayout)newValue);
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
			case VulkanPackage.ATTACHMENT_DESCRIPTION__STENCIL:
				setStencil(STENCIL_EDEFAULT);
				return;
			case VulkanPackage.ATTACHMENT_DESCRIPTION__SAMPLES:
				setSamples(SAMPLES_EDEFAULT);
				return;
			case VulkanPackage.ATTACHMENT_DESCRIPTION__LOAD_OP:
				setLoadOp(LOAD_OP_EDEFAULT);
				return;
			case VulkanPackage.ATTACHMENT_DESCRIPTION__STORE_OP:
				setStoreOp(STORE_OP_EDEFAULT);
				return;
			case VulkanPackage.ATTACHMENT_DESCRIPTION__STENCIL_LOAD_OP:
				setStencilLoadOp(STENCIL_LOAD_OP_EDEFAULT);
				return;
			case VulkanPackage.ATTACHMENT_DESCRIPTION__STENCIL_STORE_OP:
				setStencilStoreOp(STENCIL_STORE_OP_EDEFAULT);
				return;
			case VulkanPackage.ATTACHMENT_DESCRIPTION__INITIAL_LAYOUT:
				setInitialLayout(INITIAL_LAYOUT_EDEFAULT);
				return;
			case VulkanPackage.ATTACHMENT_DESCRIPTION__FINAL_LAYOUT:
				setFinalLayout(FINAL_LAYOUT_EDEFAULT);
				return;
			case VulkanPackage.ATTACHMENT_DESCRIPTION__REF_LAYOUT:
				setRefLayout(REF_LAYOUT_EDEFAULT);
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
			case VulkanPackage.ATTACHMENT_DESCRIPTION__STENCIL:
				return stencil != STENCIL_EDEFAULT;
			case VulkanPackage.ATTACHMENT_DESCRIPTION__SAMPLES:
				return samples != SAMPLES_EDEFAULT;
			case VulkanPackage.ATTACHMENT_DESCRIPTION__LOAD_OP:
				return loadOp != LOAD_OP_EDEFAULT;
			case VulkanPackage.ATTACHMENT_DESCRIPTION__STORE_OP:
				return storeOp != STORE_OP_EDEFAULT;
			case VulkanPackage.ATTACHMENT_DESCRIPTION__STENCIL_LOAD_OP:
				return stencilLoadOp != STENCIL_LOAD_OP_EDEFAULT;
			case VulkanPackage.ATTACHMENT_DESCRIPTION__STENCIL_STORE_OP:
				return stencilStoreOp != STENCIL_STORE_OP_EDEFAULT;
			case VulkanPackage.ATTACHMENT_DESCRIPTION__INITIAL_LAYOUT:
				return initialLayout != INITIAL_LAYOUT_EDEFAULT;
			case VulkanPackage.ATTACHMENT_DESCRIPTION__FINAL_LAYOUT:
				return finalLayout != FINAL_LAYOUT_EDEFAULT;
			case VulkanPackage.ATTACHMENT_DESCRIPTION__REF_LAYOUT:
				return refLayout != REF_LAYOUT_EDEFAULT;
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
		result.append(" (stencil: ");
		result.append(stencil);
		result.append(", samples: ");
		result.append(samples);
		result.append(", loadOp: ");
		result.append(loadOp);
		result.append(", storeOp: ");
		result.append(storeOp);
		result.append(", stencilLoadOp: ");
		result.append(stencilLoadOp);
		result.append(", stencilStoreOp: ");
		result.append(stencilStoreOp);
		result.append(", initialLayout: ");
		result.append(initialLayout);
		result.append(", finalLayout: ");
		result.append(finalLayout);
		result.append(", refLayout: ");
		result.append(refLayout);
		result.append(')');
		return result.toString();
	}

} //AttachmentDescriptionImpl
