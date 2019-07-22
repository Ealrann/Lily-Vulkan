/**
 */
package org.sheepy.lily.vulkan.model.process.graphic.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.sheepy.lily.vulkan.model.process.graphic.AttachmentDescription;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;

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
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.AttachmentDescriptionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.AttachmentDescriptionImpl#getSamples <em>Samples</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.AttachmentDescriptionImpl#getLoadOp <em>Load Op</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.AttachmentDescriptionImpl#getStoreOp <em>Store Op</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.AttachmentDescriptionImpl#getStencilLoadOp <em>Stencil Load Op</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.AttachmentDescriptionImpl#getStencilStoreOp <em>Stencil Store Op</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.AttachmentDescriptionImpl#getInitialLayout <em>Initial Layout</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.AttachmentDescriptionImpl#getFinalLayout <em>Final Layout</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AttachmentDescriptionImpl extends MinimalEObjectImpl.Container implements AttachmentDescription
{
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttachmentDescriptionImpl()
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
		return GraphicPackage.Literals.ATTACHMENT_DESCRIPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName()
	{
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName)
	{
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.ATTACHMENT_DESCRIPTION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ESampleCount getSamples()
	{
		return samples;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSamples(ESampleCount newSamples)
	{
		ESampleCount oldSamples = samples;
		samples = newSamples == null ? SAMPLES_EDEFAULT : newSamples;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.ATTACHMENT_DESCRIPTION__SAMPLES, oldSamples, samples));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttachmentLoadOp getLoadOp()
	{
		return loadOp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLoadOp(EAttachmentLoadOp newLoadOp)
	{
		EAttachmentLoadOp oldLoadOp = loadOp;
		loadOp = newLoadOp == null ? LOAD_OP_EDEFAULT : newLoadOp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.ATTACHMENT_DESCRIPTION__LOAD_OP, oldLoadOp, loadOp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttachmentStoreOp getStoreOp()
	{
		return storeOp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStoreOp(EAttachmentStoreOp newStoreOp)
	{
		EAttachmentStoreOp oldStoreOp = storeOp;
		storeOp = newStoreOp == null ? STORE_OP_EDEFAULT : newStoreOp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.ATTACHMENT_DESCRIPTION__STORE_OP, oldStoreOp, storeOp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttachmentLoadOp getStencilLoadOp()
	{
		return stencilLoadOp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStencilLoadOp(EAttachmentLoadOp newStencilLoadOp)
	{
		EAttachmentLoadOp oldStencilLoadOp = stencilLoadOp;
		stencilLoadOp = newStencilLoadOp == null ? STENCIL_LOAD_OP_EDEFAULT : newStencilLoadOp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.ATTACHMENT_DESCRIPTION__STENCIL_LOAD_OP, oldStencilLoadOp, stencilLoadOp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttachmentStoreOp getStencilStoreOp()
	{
		return stencilStoreOp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStencilStoreOp(EAttachmentStoreOp newStencilStoreOp)
	{
		EAttachmentStoreOp oldStencilStoreOp = stencilStoreOp;
		stencilStoreOp = newStencilStoreOp == null ? STENCIL_STORE_OP_EDEFAULT : newStencilStoreOp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.ATTACHMENT_DESCRIPTION__STENCIL_STORE_OP, oldStencilStoreOp, stencilStoreOp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EImageLayout getInitialLayout()
	{
		return initialLayout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInitialLayout(EImageLayout newInitialLayout)
	{
		EImageLayout oldInitialLayout = initialLayout;
		initialLayout = newInitialLayout == null ? INITIAL_LAYOUT_EDEFAULT : newInitialLayout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.ATTACHMENT_DESCRIPTION__INITIAL_LAYOUT, oldInitialLayout, initialLayout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EImageLayout getFinalLayout()
	{
		return finalLayout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFinalLayout(EImageLayout newFinalLayout)
	{
		EImageLayout oldFinalLayout = finalLayout;
		finalLayout = newFinalLayout == null ? FINAL_LAYOUT_EDEFAULT : newFinalLayout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.ATTACHMENT_DESCRIPTION__FINAL_LAYOUT, oldFinalLayout, finalLayout));
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
			case GraphicPackage.ATTACHMENT_DESCRIPTION__NAME:
				return getName();
			case GraphicPackage.ATTACHMENT_DESCRIPTION__SAMPLES:
				return getSamples();
			case GraphicPackage.ATTACHMENT_DESCRIPTION__LOAD_OP:
				return getLoadOp();
			case GraphicPackage.ATTACHMENT_DESCRIPTION__STORE_OP:
				return getStoreOp();
			case GraphicPackage.ATTACHMENT_DESCRIPTION__STENCIL_LOAD_OP:
				return getStencilLoadOp();
			case GraphicPackage.ATTACHMENT_DESCRIPTION__STENCIL_STORE_OP:
				return getStencilStoreOp();
			case GraphicPackage.ATTACHMENT_DESCRIPTION__INITIAL_LAYOUT:
				return getInitialLayout();
			case GraphicPackage.ATTACHMENT_DESCRIPTION__FINAL_LAYOUT:
				return getFinalLayout();
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
			case GraphicPackage.ATTACHMENT_DESCRIPTION__NAME:
				setName((String)newValue);
				return;
			case GraphicPackage.ATTACHMENT_DESCRIPTION__SAMPLES:
				setSamples((ESampleCount)newValue);
				return;
			case GraphicPackage.ATTACHMENT_DESCRIPTION__LOAD_OP:
				setLoadOp((EAttachmentLoadOp)newValue);
				return;
			case GraphicPackage.ATTACHMENT_DESCRIPTION__STORE_OP:
				setStoreOp((EAttachmentStoreOp)newValue);
				return;
			case GraphicPackage.ATTACHMENT_DESCRIPTION__STENCIL_LOAD_OP:
				setStencilLoadOp((EAttachmentLoadOp)newValue);
				return;
			case GraphicPackage.ATTACHMENT_DESCRIPTION__STENCIL_STORE_OP:
				setStencilStoreOp((EAttachmentStoreOp)newValue);
				return;
			case GraphicPackage.ATTACHMENT_DESCRIPTION__INITIAL_LAYOUT:
				setInitialLayout((EImageLayout)newValue);
				return;
			case GraphicPackage.ATTACHMENT_DESCRIPTION__FINAL_LAYOUT:
				setFinalLayout((EImageLayout)newValue);
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
			case GraphicPackage.ATTACHMENT_DESCRIPTION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GraphicPackage.ATTACHMENT_DESCRIPTION__SAMPLES:
				setSamples(SAMPLES_EDEFAULT);
				return;
			case GraphicPackage.ATTACHMENT_DESCRIPTION__LOAD_OP:
				setLoadOp(LOAD_OP_EDEFAULT);
				return;
			case GraphicPackage.ATTACHMENT_DESCRIPTION__STORE_OP:
				setStoreOp(STORE_OP_EDEFAULT);
				return;
			case GraphicPackage.ATTACHMENT_DESCRIPTION__STENCIL_LOAD_OP:
				setStencilLoadOp(STENCIL_LOAD_OP_EDEFAULT);
				return;
			case GraphicPackage.ATTACHMENT_DESCRIPTION__STENCIL_STORE_OP:
				setStencilStoreOp(STENCIL_STORE_OP_EDEFAULT);
				return;
			case GraphicPackage.ATTACHMENT_DESCRIPTION__INITIAL_LAYOUT:
				setInitialLayout(INITIAL_LAYOUT_EDEFAULT);
				return;
			case GraphicPackage.ATTACHMENT_DESCRIPTION__FINAL_LAYOUT:
				setFinalLayout(FINAL_LAYOUT_EDEFAULT);
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
			case GraphicPackage.ATTACHMENT_DESCRIPTION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GraphicPackage.ATTACHMENT_DESCRIPTION__SAMPLES:
				return samples != SAMPLES_EDEFAULT;
			case GraphicPackage.ATTACHMENT_DESCRIPTION__LOAD_OP:
				return loadOp != LOAD_OP_EDEFAULT;
			case GraphicPackage.ATTACHMENT_DESCRIPTION__STORE_OP:
				return storeOp != STORE_OP_EDEFAULT;
			case GraphicPackage.ATTACHMENT_DESCRIPTION__STENCIL_LOAD_OP:
				return stencilLoadOp != STENCIL_LOAD_OP_EDEFAULT;
			case GraphicPackage.ATTACHMENT_DESCRIPTION__STENCIL_STORE_OP:
				return stencilStoreOp != STENCIL_STORE_OP_EDEFAULT;
			case GraphicPackage.ATTACHMENT_DESCRIPTION__INITIAL_LAYOUT:
				return initialLayout != INITIAL_LAYOUT_EDEFAULT;
			case GraphicPackage.ATTACHMENT_DESCRIPTION__FINAL_LAYOUT:
				return finalLayout != FINAL_LAYOUT_EDEFAULT;
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
		result.append(" (name: ");
		result.append(name);
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
		result.append(')');
		return result.toString();
	}

} //AttachmentDescriptionImpl
