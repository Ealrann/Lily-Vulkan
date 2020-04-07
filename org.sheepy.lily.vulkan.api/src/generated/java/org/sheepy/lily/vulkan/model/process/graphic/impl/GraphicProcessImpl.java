/**
 */
package org.sheepy.lily.vulkan.model.process.graphic.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.sheepy.lily.core.model.maintainer.Maintainable;
import org.sheepy.lily.core.model.maintainer.Maintainer;
import org.sheepy.lily.core.model.maintainer.MaintainerPackage;

import org.sheepy.lily.vulkan.model.process.graphic.AttachmentPkg;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
import org.sheepy.lily.vulkan.model.process.graphic.SwapImageAttachment;
import org.sheepy.lily.vulkan.model.process.impl.AbstractProcessImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Process</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicProcessImpl#getMaintainer <em>Maintainer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicProcessImpl#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicProcessImpl#getColorAttachment <em>Color Attachment</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicProcessImpl#getAttachmentPkg <em>Attachment Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicProcessImpl#getSubpasses <em>Subpasses</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GraphicProcessImpl extends AbstractProcessImpl implements GraphicProcess
{
	/**
	 * The cached value of the '{@link #getMaintainer() <em>Maintainer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaintainer()
	 * @generated
	 * @ordered
	 */
	protected Maintainer<GraphicProcess> maintainer;

	/**
	 * The cached value of the '{@link #getConfiguration() <em>Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfiguration()
	 * @generated
	 * @ordered
	 */
	protected GraphicConfiguration configuration;

	/**
	 * The cached value of the '{@link #getColorAttachment() <em>Color Attachment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColorAttachment()
	 * @generated
	 * @ordered
	 */
	protected SwapImageAttachment colorAttachment;

	/**
	 * The cached value of the '{@link #getAttachmentPkg() <em>Attachment Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttachmentPkg()
	 * @generated
	 * @ordered
	 */
	protected AttachmentPkg attachmentPkg;

	/**
	 * The cached value of the '{@link #getSubpasses() <em>Subpasses</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubpasses()
	 * @generated
	 * @ordered
	 */
	protected EList<Subpass> subpasses;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphicProcessImpl()
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
		return GraphicPackage.Literals.GRAPHIC_PROCESS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Maintainer<GraphicProcess> getMaintainer()
	{
		if (maintainer != null && ((EObject)maintainer).eIsProxy())
		{
			InternalEObject oldMaintainer = maintainer;
			maintainer = (Maintainer<GraphicProcess>)eResolveProxy(oldMaintainer);
			if (maintainer != oldMaintainer)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphicPackage.GRAPHIC_PROCESS__MAINTAINER, oldMaintainer, maintainer));
			}
		}
		return maintainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Maintainer<GraphicProcess> basicGetMaintainer()
	{
		return maintainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMaintainer(Maintainer<GraphicProcess> newMaintainer, NotificationChain msgs)
	{
		Maintainer<GraphicProcess> oldMaintainer = maintainer;
		maintainer = newMaintainer;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHIC_PROCESS__MAINTAINER, oldMaintainer, newMaintainer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMaintainer(Maintainer<GraphicProcess> newMaintainer)
	{
		if (newMaintainer != maintainer)
		{
			NotificationChain msgs = null;
			if (maintainer != null)
				msgs = ((InternalEObject)maintainer).eInverseRemove(this, MaintainerPackage.MAINTAINER__MAINTAINED, Maintainer.class, msgs);
			if (newMaintainer != null)
				msgs = ((InternalEObject)newMaintainer).eInverseAdd(this, MaintainerPackage.MAINTAINER__MAINTAINED, Maintainer.class, msgs);
			msgs = basicSetMaintainer(newMaintainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHIC_PROCESS__MAINTAINER, newMaintainer, newMaintainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GraphicConfiguration getConfiguration()
	{
		return configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConfiguration(GraphicConfiguration newConfiguration, NotificationChain msgs)
	{
		GraphicConfiguration oldConfiguration = configuration;
		configuration = newConfiguration;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, oldConfiguration, newConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConfiguration(GraphicConfiguration newConfiguration)
	{
		if (newConfiguration != configuration)
		{
			NotificationChain msgs = null;
			if (configuration != null)
				msgs = ((InternalEObject)configuration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, null, msgs);
			if (newConfiguration != null)
				msgs = ((InternalEObject)newConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, null, msgs);
			msgs = basicSetConfiguration(newConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, newConfiguration, newConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SwapImageAttachment getColorAttachment()
	{
		return colorAttachment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetColorAttachment(SwapImageAttachment newColorAttachment, NotificationChain msgs)
	{
		SwapImageAttachment oldColorAttachment = colorAttachment;
		colorAttachment = newColorAttachment;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHIC_PROCESS__COLOR_ATTACHMENT, oldColorAttachment, newColorAttachment);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setColorAttachment(SwapImageAttachment newColorAttachment)
	{
		if (newColorAttachment != colorAttachment)
		{
			NotificationChain msgs = null;
			if (colorAttachment != null)
				msgs = ((InternalEObject)colorAttachment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHIC_PROCESS__COLOR_ATTACHMENT, null, msgs);
			if (newColorAttachment != null)
				msgs = ((InternalEObject)newColorAttachment).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHIC_PROCESS__COLOR_ATTACHMENT, null, msgs);
			msgs = basicSetColorAttachment(newColorAttachment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHIC_PROCESS__COLOR_ATTACHMENT, newColorAttachment, newColorAttachment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AttachmentPkg getAttachmentPkg()
	{
		return attachmentPkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAttachmentPkg(AttachmentPkg newAttachmentPkg, NotificationChain msgs)
	{
		AttachmentPkg oldAttachmentPkg = attachmentPkg;
		attachmentPkg = newAttachmentPkg;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHIC_PROCESS__ATTACHMENT_PKG, oldAttachmentPkg, newAttachmentPkg);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAttachmentPkg(AttachmentPkg newAttachmentPkg)
	{
		if (newAttachmentPkg != attachmentPkg)
		{
			NotificationChain msgs = null;
			if (attachmentPkg != null)
				msgs = ((InternalEObject)attachmentPkg).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHIC_PROCESS__ATTACHMENT_PKG, null, msgs);
			if (newAttachmentPkg != null)
				msgs = ((InternalEObject)newAttachmentPkg).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHIC_PROCESS__ATTACHMENT_PKG, null, msgs);
			msgs = basicSetAttachmentPkg(newAttachmentPkg, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHIC_PROCESS__ATTACHMENT_PKG, newAttachmentPkg, newAttachmentPkg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Subpass> getSubpasses()
	{
		if (subpasses == null)
		{
			subpasses = new EObjectContainmentEList<Subpass>(Subpass.class, this, GraphicPackage.GRAPHIC_PROCESS__SUBPASSES);
		}
		return subpasses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case GraphicPackage.GRAPHIC_PROCESS__MAINTAINER:
				if (maintainer != null)
					msgs = ((InternalEObject)maintainer).eInverseRemove(this, MaintainerPackage.MAINTAINER__MAINTAINED, Maintainer.class, msgs);
				return basicSetMaintainer((Maintainer<GraphicProcess>)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
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
			case GraphicPackage.GRAPHIC_PROCESS__MAINTAINER:
				return basicSetMaintainer(null, msgs);
			case GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION:
				return basicSetConfiguration(null, msgs);
			case GraphicPackage.GRAPHIC_PROCESS__COLOR_ATTACHMENT:
				return basicSetColorAttachment(null, msgs);
			case GraphicPackage.GRAPHIC_PROCESS__ATTACHMENT_PKG:
				return basicSetAttachmentPkg(null, msgs);
			case GraphicPackage.GRAPHIC_PROCESS__SUBPASSES:
				return ((InternalEList<?>)getSubpasses()).basicRemove(otherEnd, msgs);
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
			case GraphicPackage.GRAPHIC_PROCESS__MAINTAINER:
				if (resolve) return getMaintainer();
				return basicGetMaintainer();
			case GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION:
				return getConfiguration();
			case GraphicPackage.GRAPHIC_PROCESS__COLOR_ATTACHMENT:
				return getColorAttachment();
			case GraphicPackage.GRAPHIC_PROCESS__ATTACHMENT_PKG:
				return getAttachmentPkg();
			case GraphicPackage.GRAPHIC_PROCESS__SUBPASSES:
				return getSubpasses();
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
			case GraphicPackage.GRAPHIC_PROCESS__MAINTAINER:
				setMaintainer((Maintainer<GraphicProcess>)newValue);
				return;
			case GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION:
				setConfiguration((GraphicConfiguration)newValue);
				return;
			case GraphicPackage.GRAPHIC_PROCESS__COLOR_ATTACHMENT:
				setColorAttachment((SwapImageAttachment)newValue);
				return;
			case GraphicPackage.GRAPHIC_PROCESS__ATTACHMENT_PKG:
				setAttachmentPkg((AttachmentPkg)newValue);
				return;
			case GraphicPackage.GRAPHIC_PROCESS__SUBPASSES:
				getSubpasses().clear();
				getSubpasses().addAll((Collection<? extends Subpass>)newValue);
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
			case GraphicPackage.GRAPHIC_PROCESS__MAINTAINER:
				setMaintainer((Maintainer<GraphicProcess>)null);
				return;
			case GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION:
				setConfiguration((GraphicConfiguration)null);
				return;
			case GraphicPackage.GRAPHIC_PROCESS__COLOR_ATTACHMENT:
				setColorAttachment((SwapImageAttachment)null);
				return;
			case GraphicPackage.GRAPHIC_PROCESS__ATTACHMENT_PKG:
				setAttachmentPkg((AttachmentPkg)null);
				return;
			case GraphicPackage.GRAPHIC_PROCESS__SUBPASSES:
				getSubpasses().clear();
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
			case GraphicPackage.GRAPHIC_PROCESS__MAINTAINER:
				return maintainer != null;
			case GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION:
				return configuration != null;
			case GraphicPackage.GRAPHIC_PROCESS__COLOR_ATTACHMENT:
				return colorAttachment != null;
			case GraphicPackage.GRAPHIC_PROCESS__ATTACHMENT_PKG:
				return attachmentPkg != null;
			case GraphicPackage.GRAPHIC_PROCESS__SUBPASSES:
				return subpasses != null && !subpasses.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
	{
		if (baseClass == Maintainable.class)
		{
			switch (derivedFeatureID)
			{
				case GraphicPackage.GRAPHIC_PROCESS__MAINTAINER: return MaintainerPackage.MAINTAINABLE__MAINTAINER;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
	{
		if (baseClass == Maintainable.class)
		{
			switch (baseFeatureID)
			{
				case MaintainerPackage.MAINTAINABLE__MAINTAINER: return GraphicPackage.GRAPHIC_PROCESS__MAINTAINER;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //GraphicProcessImpl
